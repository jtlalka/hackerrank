package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class BalancedSearchTree<Key extends Comparable<Key>, Value> implements Iterable<Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public BalancedSearchTree() {
        this.root = null;
        this.size = 0;
    }

    public Value get(Key key) {
        Node node = get(root, key);
        return node != null ? node.value : null;
    }

    private Node get(Node node, Key key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            size++;
            return new Node(key, value, RED);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private Node rotateRight(Node node) {
        assert (node != null) && isRed(node.left);
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        return left;
    }

    private Node rotateLeft(Node node) {
        assert (node != null) && isRed(node.right);
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    private void flipColors(Node node) {
        assert !isRed(node) && isRed(node.left) && isRed(node.right);
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public boolean contains(Key key) {
        return get(root, key) != null;
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node node) {
        Key key = null;
        while (node != null) {
            key = node.key;
            node = node.left;
        }
        return key;
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node node) {
        Key key = null;
        while (node != null) {
            key = node.key;
            node = node.right;
        }
        return key;
    }

    public LinkList<Key> keys() {
        LinkList<Key> list = new LinkList<>();
        keys(root, list);
        return list;
    }

    private void keys(Node node, LinkList<Key> list) {
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
