package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class DynamicTable<K, V> implements Iterable<V> {

    private LinkList<K> keys;
    private DynamicArray<V> values;

    public DynamicTable() {
        this.keys = new LinkList<>();
        this.values = new DynamicArray<>();
    }

    public DynamicTable(K key, V value) {
        this();
        this.insert(key, value);
    }

    public V get(K key) {
        return values.get(indexOf(key));
    }

    public void insert(K key, V value) {
        if (keys.contains(key)) {
            values.update(indexOf(key), value);
        } else {
            keys.addLast(key);
            values.insert(value);
        }
    }

    public void update(K key, V value) {
        values.update(indexOf(key), value);
    }

    public void delete(K key) {
        int index = indexOf(key);
        keys.remove(index);
        values.delete(index);
    }

    public int indexOf(K key) {
        return keys.indexOf(key);
    }

    public LinkList<V> toList() {
        return values.toList();
    }

    public int size() {
        return keys.size();
    }

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return values.iterator();
    }
}
