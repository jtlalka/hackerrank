package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Iterable<V> {

    private class Entry {

        private K key;

        private V value;

        private int hash;

        private Entry next;

        public Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        public Entry getEntry(int hash, K key) {
            if (isSameKey(hash, key)) {
                return this;
            } else if (next != null) {
                return next.getEntry(hash, key);
            } else {
                return null;
            }
        }

        public V getValue(int hash, K key) {
            if (isSameKey(hash, key)) {
                return value;
            } else if (next != null) {
                return next.getValue(hash, key);
            } else {
                return null;
            }
        }

        public boolean insert(int hash, K key, V value) {
            if (isSameKey(hash, key)) {
                this.value = value;
                return false;
            } else {
                return next == null && setupNext(new Entry(key, value, hash)) || next.insert(hash, key, value);
            }
        }

        public boolean isSameKey(int hash, K key) {
            return (this.hash == hash && this.key != null && this.key.equals(key))
                    || (key == null && this.key == null);
        }

        private boolean setupNext(Entry entry) {
            return (next = entry) != null;
        }
    }

    private Entry head;

    private int size;

    public HashMap() {
        this.head = null;
        this.size = 0;
    }

    public HashMap(K key, V value) {
        this.insert(key, value);
    }

    public V get(K key) {
        return head != null ? head.getValue(getHashCode(key), key) : null;
    }

    public void insert(K key, V value) {
        if (head == null) {
            head = new Entry(key, value, getHashCode(key));
            incrementSize();
        } else {
            if (head.insert(getHashCode(key), key, value)) {
                incrementSize();
            }
        }
    }

    public void delete(K key) {
        int hash = getHashCode(key);
        Entry parent = null;
        Entry entry = head;

        while (entry != null) {
            if (entry.isSameKey(hash, key)) {
                if (parent == null) {
                    head = head.next;
                } else {
                    parent.next = entry.next;
                }
                decrementSize();
                return;
            }
            parent = entry;
            entry = entry.next;
        }
        throw new NoSuchElementException("There is no such value.");
    }

    public boolean contains(K key) {
        return head != null && head.getEntry(getHashCode(key), key) != null;
    }

    public LinkList<V> toList() {
        LinkList<V> valueList = new LinkList<>();
        Entry entry = head;

        while (entry != null) {
            valueList.addLast(entry.value);
            entry = entry.next;
        }
        return valueList;
    }

    private int getHashCode(K key) {
        return key != null ? key.hashCode() : 0;
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
        return this.toList().iterator();
    }
}
