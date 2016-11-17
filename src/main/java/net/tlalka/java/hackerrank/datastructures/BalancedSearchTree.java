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

    public void delete(Key key) {
        if (!contains(key)) return;
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node delete(Node node, Key key) {
        if (key.compareTo(node.key) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left)) node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && (node.right == null)) {
                size--;
                return null;
            }
            if (!isRed(node.right) && !isRed(node.right.left)) node = moveRedRight(node);

            if (key.compareTo(node.key) == 0) {
                Node right = min(node.right);
                node.key = right.key;
                node.value = right.value;
                node.right = deleteMin(node.right);
                size--;
            } else {
                node.right = delete(node.right, key);
            }
        }
        return balance(node);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return null;
        if (!isRed(node.left) && !isRed(node.left.left)) node = moveRedLeft(node);

        node.left = deleteMin(node.left);
        return balance(node);
    }

    private Node balance(Node node) {
        if (isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);
        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private Node moveRedLeft(Node node) {
        flipColors(node);

        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }

    private Node moveRedRight(Node node) {
        flipColors(node);

        if (isRed(node.left.left)) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = left.right.color;
        left.right.color = RED;
        return left;
    }

    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = right.left.color;
        right.left.color = RED;
        return right;
    }

    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    public Key min() {
        return root != null ? min(root).key : null;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    public Key max() {
        return root != null ? max(root).key : null;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean contains(Key key) {
        return get(root, key) != null;
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

    public boolean checkTree() {
        return isBST(root, null, null) && is23(root) && isBalanced(root);
    }

    private boolean isBST(Node node, Key min, Key max) {
        return node == null
                || (min == null || min.compareTo(node.key) < 0)
                && (max == null || max.compareTo(node.key) > 0)
                && isBST(node.left, min, node.key)
                && isBST(node.right, node.key, max);
    }

    private boolean is23(Node node) {
        return node == null
                || !isRed(node.right)
                && !(node != root && isRed(node) && isRed(node.left))
                && is23(node.left) && is23(node.right);
    }

    private boolean isBalanced(Node node) {
        int black = 0;
        while (node != null) {
            if (!isRed(node)) black++;
            node = node.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node node, int black) {
        if (node == null) return black == 0;
        if (!isRed(node)) black--;
        return isBalanced(node.left, black) && isBalanced(node.right, black);
    }

    @Override
    public Iterator<Value> iterator() {
        return this.values().iterator();
    }
}
