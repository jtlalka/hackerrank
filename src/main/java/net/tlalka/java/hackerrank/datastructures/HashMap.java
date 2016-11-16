package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class HashMap<Key, Value> implements Iterable<Value> {

    private Node head;
    private int size;

    private class Node {
        private Key key;
        private Value value;
        private int hash;
        private Node next;

        public Node(Key key, Value value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    public HashMap() {
        this.head = null;
        this.size = 0;
    }

    public HashMap(Key key, Value value) {
        this.put(key, value);
    }

    public Value get(Key key) {
        Node node = get(head, key, getHashCode(key));
        return node != null ? node.value : null;
    }

    private Node get(Node node, Key key, int hash) {
        while (node != null) {
            if (compare(node, key, hash)) return node;
            node = node.next;
        }
        return null;
    }

    public void put(Key key, Value value) {
        head = put(head, key, value, getHashCode(key));
    }

    private Node put(Node node, Key key, Value value, int hash) {
        if (node == null) {
            incrementSize();
            return new Node(key, value, hash);
        } else {
            if (compare(node, key, hash)) node.value = value;
            else node.next = put(node.next, key, value, hash);
            return node;
        }
    }

    public void delete(Key key) {
        head = delete(head, key, getHashCode(key));
    }

    private Node delete(Node node, Key key, int hash) {
        if (node == null) {
            return null;
        } else if (compare(node, key, hash)) {
            decrementSize();
            return node.next;
        } else {
            return delete(node.next, key, hash);
        }
    }

    public boolean contains(Key key) {
        return get(head, key, getHashCode(key)) != null;
    }

    public LinkList<Value> values() {
        LinkList<Value> values = new LinkList<>();
        values(head, values);
        return values;
    }

    private void values(Node node, LinkList<Value> values) {
        if (node == null) return;
        values.addLast(node.value);
        values(node.next, values);
    }

    private boolean compare(Node node, Key key, int hash) {
        return (node.hash == hash && node.key != null && node.key.equals(key))
                || (node.key == null && key == null);
    }

    private int getHashCode(Key key) {
        return key != null ? key.hashCode() : 0;
    }

    private int incrementSize() {
        return size++;
    }

    private int decrementSize() {
        return size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Value> iterator() {
        return this.values().iterator();
    }
}
