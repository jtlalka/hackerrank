package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class BinarySearchTree<Value> implements Iterable<Value> {

    private Node root;
    private int size;

    private class Node {
        private int key;
        private Value value;
        private Node left, right;

        public Node(int key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public Value get(int key) {
        Node node = get(root, key);
        return node != null ? node.value : null;
    }

    private Node get(Node node, int key) {
        while (node != null) {
            if (node.key > key) node = node.left;
            else if (node.key < key) node = node.right;
            else return node;
        }
        return null;
    }

    public void put(int key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, int key, Value value) {
        if (node == null) {
            incrementSize();
            return new Node(key, value);
        } else {
            if (node.key > key) node.left = put(node.left, key, value);
            else if (node.key < key) node.right = put(node.right, key, value);
            else node.value = value;
            return node;
        }
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key > key) node.left = delete(node.left, key);
        else if (node.key < key) node.right = delete(node.right, key);
        else {
            decrementSize();
            if (node.right == null) return node.left;
            else if (node.left == null) return node.right;
            else {
                Node t = node;
                node = min(t.right);
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
        }
        return node;
    }

    public int min() {
        if (isEmpty()) return 0;
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    public int max() {
        if (isEmpty()) return 0;
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            return node;
        }
    }

    public boolean contains(int key) {
        return get(root, key) != null;
    }

    public LinkList<Integer> keys() {
        LinkList<Integer> list = new LinkList<>();
        keys(root, list);
        return list;
    }

    private void keys(Node node, LinkList<Integer> list) {
        if (node == null) return;
        keys(node.left, list);
        list.addLast(node.key);
        keys(node.right, list);
    }

    public LinkList<Value> values() {
        LinkList<Value> list = new LinkList<>();
        values(root, list);
        return list;
    }

    private void values(Node node, LinkList<Value> list) {
        if (node == null) return;
        values(node.left, list);
        list.addLast(node.value);
        values(node.right, list);
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
