package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class HashTree<K, V> implements Iterable<V> {

    private BinaryTree<HashMap<K, V>> tree;

    private int size;

    public HashTree() {
        this.tree = new BinaryTree<>();
        this.size = 0;
    }

    public HashTree(K key, V value) {
        this();
        this.insert(key, value);
    }

    public V get(K key) {
        HashMap<K, V> entries = tree.get(getHashCode(key));
        return entries != null ? entries.get(key) : null;
    }

    public void insert(K key, V value) {
        int hash = getHashCode(key);
        HashMap<K, V> entries = tree.get(hash);

        if (entries == null) {
            tree.insert(hash, new HashMap<>(key, value));
            incrementSize();
        } else {
            int mapSize = entries.getSize();
            entries.insert(key, value);

            if (mapSize < entries.getSize()) {
                incrementSize();
            }
        }
    }

    public void delete(K key) {
        HashMap<K, V> entries = tree.get(getHashCode(key));
        if (entries != null) {
            int mapSize = entries.getSize();
            entries.delete(key);

            if (mapSize > entries.getSize()) {
                decrementSize();
            }
        }
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
