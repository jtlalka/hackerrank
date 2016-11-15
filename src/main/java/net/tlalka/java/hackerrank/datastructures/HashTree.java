package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class HashTree<K, V> implements Iterable<V> {

    private BinaryTree<HashMap<K, V>> tree;

    public HashTree() {
        this.tree = new BinaryTree<>();
    }

    public HashTree(K key, V value) {
        this();
        this.insert(key, value);
    }

    public void insert(K key, V value) {
        int hash = getHashCode(key);
        HashMap<K, V> entries = tree.get(hash);

        if (entries != null) {
            entries.insert(key, value);
        } else {
            tree.insert(hash, new HashMap<>(key, value));
        }
    }

    public V get(K key) {
        HashMap<K, V> entries = tree.get(getHashCode(key));
        return entries != null ? entries.get(key) : null;
    }

    public boolean contains(K key) {
        HashMap<K, V> entries = tree.get(getHashCode(key));
        return entries != null && entries.contains(key);
    }

    private int getHashCode(K key) {
        return key != null ? key.hashCode() : 0;
    }

    public LinkList<V> toList() {
        LinkList<V> valueList = new LinkList<>();
        if (tree != null) {
            LinkList<HashMap<K, V>> mapList = tree.toList();
            mapList.forEach(m -> valueList.addLast(m.toList()));
        }
        return valueList;
    }

    public int getSize() {
        return this.toList().getSize();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return this.toList().iterator();
    }
}
