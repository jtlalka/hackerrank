package net.tlalka.java.hackerrank.datastructures;

import java.util.Collection;
import java.util.Iterator;

public class DynamicArray<E> implements Iterable<E> {

    private final static int DEFAULT_LENGTH = 100;

    private final static int DEFAULT_VECTOR = 100;

    private final static int MAX_LENGTH = 2000000;

    private Object[] items;

    private int vector;

    private int size;

    public DynamicArray() {
        this(DEFAULT_LENGTH, DEFAULT_VECTOR);
    }

    public DynamicArray(int length, int vector) {
        this.items = new Object[length];
        this.vector = vector;
        this.size = 0;
    }

    public DynamicArray(Collection<E> elements) {
        this(elements.size(), DEFAULT_VECTOR);
        elements.forEach(this::insert);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) this.items[index];
    }

    public void update(int index, E element) {
        checkIndex(index);
        this.items[index] = element;
    }

    public void delete(int index) {
        checkIndex(index);
        System.arraycopy(items, index + 1, items, index, --size - index);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of range [0, %d)", index, size));
        }
    }

    public void insert(E element) {
        ensureCapacity();
        this.items[size++] = element;
    }

    private void ensureCapacity() {
        if (items.length == size) {
            checkMaxSize(size + vector);
            Object[] newArray = new Object[size + vector];
            System.arraycopy(items, 0, newArray, 0, size);
            items = newArray;
        }
    }

    private void checkMaxSize(int size) {
        if (size < 0 || size > MAX_LENGTH) {
            throw new IndexOutOfBoundsException(String.format("Max size for dynamic array is: %d", size));
        }
    }

    public LinkList<E> toList() {
        LinkList<E> list = new LinkList<>();
        for (int i = 0; i < size; i++) {
            list.addLast(this.get(i));
        }
        return list;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return this.toList().iterator();
    }
}
