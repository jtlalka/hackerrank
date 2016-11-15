package net.tlalka.java.hackerrank.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkList<V> implements Iterable<V> {

    private class Node {

        private V value;

        private Node previous;

        private Node next;

        public Node(V value) {
            this(value, null, null);
        }

        public Node(V value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        public Node addPrevious(V value) {
            return previous = new Node(value, previous, this);
        }

        public Node addNext(V value) {
            return next = new Node(value, this, next);
        }

        public Node remove() {
            if (previous != null) {
                previous.next = next;
            }
            if (next != null) {
                next.previous = previous;
            }
            return this;
        }

        public Node revers() {
            Node node = previous;
            previous = next;
            next = node;

            if (next != null) {
                return next.revers();
            } else {
                return this;
            }
        }
    }

    private class ListIterator implements Iterator<V> {

        private Node node;

        private V value;

        public ListIterator(Node node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public V next() {
            value = node.value;
            node = node.next;
            return value;
        }
    }

    private Node head;

    private Node tail;

    private int size;

    public LinkList() {
        this.size = 0;
    }

    public LinkList(V value) {
        this.addLast(value);
    }

    public LinkList(Collection<V> values) {
        values.forEach(this::addLast);
    }

    public V getFirst() {
        return getValueFromNode(head);
    }

    public V getLast() {
        return getValueFromNode(tail);
    }

    private V getValueFromNode(Node node) {
        return node != null ? node.value : null;
    }

    public void addFirst(V value) {
        if (head == null) {
            head = tail = new Node(value);
        } else {
            head = head.addPrevious(value);
        }
        incrementSize();
    }

    public void addFirst(LinkList<V> list) {
        list.forEach(this::addFirst);
    }

    public void addLast(V value) {
        if (tail == null) {
            tail = head = new Node(value);
        } else {
            tail = tail.addNext(value);
        }
        incrementSize();
    }

    public void addLast(LinkList<V> list) {
        list.forEach(this::addLast);
    }

    public V removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        } else {
            Node node = head.remove();
            decrementSize();
            head = node.next;
            return node.value;
        }
    }

    public V removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty.");
        } else {
            Node node = tail.remove();
            decrementSize();
            tail = node.previous;
            return node.value;
        }
    }

    public V remove(int index) {
        Node node = head;
        for (int i = 0; node != null; i++, node = node.next) {
            if (i == index) {
                Node removed = node.remove();
                if (removed.previous == null) {
                    head = removed.next;
                } else if (removed.next == null) {
                    tail = removed.previous;
                }
                decrementSize();
                return removed.value;
            }
        }
        throw new NoSuchElementException("There is no such value.");
    }

    public boolean contains(V value) {
        for (V item : this) {
            if (item == null) {
                return value == null;
            } else if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(V value) {
        int index = 0;
        for (V item : this) {
            if (item == null) {
                if (value == null) {
                    return index;
                }
            } else if (item.equals(value)) {
                return index;
            }
            index++;
        }
        throw new NoSuchElementException("There is no such value.");
    }

    public void revers() {
        if (head == null) {
            return;
        }
        head = tail;
        tail = head.revers();
    }

    private int incrementSize() {
        return size++;
    }

    private int decrementSize() {
        return size--;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<V> iterator() {
        return new ListIterator(head);
    }
}
