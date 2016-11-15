package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class HashMap<K, V> implements Iterable<V> {

    private class Entry {

        private K key;

        private V value;

        private int hash;

        private Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = getHashCode(key);
        }

        public V get(int hash, K key) {
            if (this.hash == hash && this.key.equals(key)) {
                return value;
            } else if (next != null) {
                return next.get(hash, key);
            } else {
                return null;
            }
        }

        public boolean insert(int hash, K key, V value) {
            if (this.hash == hash && this.key.equals(key)) {
                this.value = value;
                return false;
            } else {
                return next == null && setupNext(new Entry(key, value)) || next.insert(hash, key, value);
            }
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
        return head != null ? head.get(getHashCode(key), key) : null;
    }

    public void insert(K key, V value) {
        if (key == null) {
            throw new IndexOutOfBoundsException("Key cannot be null.");
        }
        if (head == null) {
            head = new Entry(key, value);
            size++;
        } else {
            if (head.insert(getHashCode(key), key, value)) {
                size++;
            }
        }
    }

    public void delete(K key) {
        int hashCode = getHashCode(key);
        Entry parent = null;
        Entry entry = head;

        while (entry != null) {
            if (hashCode == entry.hash && entry.key.equals(key)) {
                if (parent == null) {
                    head = head.next;
                } else {
                    parent.next = entry.next;
                }
                size--;
                break;
            }
            parent = entry;
            entry = entry.next;
        }
    }

    public boolean contains(K key) {
        return head != null && head.get(getHashCode(key), key) != null;
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
