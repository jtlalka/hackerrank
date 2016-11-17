package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class HashTree<K, V> implements Iterable<V> {

    private BalancedSearchTree<Integer, HashMap<K, V>> tree;
    private int size;

    public HashTree() {
        this.tree = new BalancedSearchTree<>();
        this.size = 0;
    }

    public HashTree(K key, V value) {
        this();
        this.put(key, value);
    }

    public V get(K key) {
        HashMap<K, V> entries = tree.get(getHashCode(key));
        return entries != null ? entries.get(key) : null;
    }

    public void put(K key, V value) {
        int hash = getHashCode(key);
        HashMap<K, V> entries = tree.get(hash);

        if (entries == null) {
            tree.put(hash, new HashMap<>(key, value));
            incrementSize();
        } else {
            int mapSize = entries.size();
            entries.put(key, value);

            if (mapSize < entries.size()) {
                incrementSize();
            }
        }
    }

    public void delete(K key) {
        int hash = getHashCode(key);
        HashMap<K, V> entries = tree.get(hash);

        if (entries != null) {
            int mapSize = entries.size();
            entries.delete(key);
            if (mapSize > entries.size()) {
                decrementSize();
            }
        }
        if (entries == null || entries.isEmpty()) {
            tree.delete(hash);
        }
    }

    public boolean contains(K key) {
        HashMap<K, V> entries = tree.get(getHashCode(key));
        return entries != null && entries.contains(key);
    }

    private int getHashCode(K key) {
        return key != null ? key.hashCode() : 0;
    }

    public LinkList<V> values() {
        LinkList<V> valueList = new LinkList<>();
        if (tree != null) {
            LinkList<HashMap<K, V>> mapList = tree.values();
            mapList.forEach(m -> valueList.addLast(m.values()));
        }
        return valueList;
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
    public Iterator<V> iterator() {
        return this.values().iterator();
    }
}
