package net.tlalka.java.hackerrank.datastructures;

import java.util.Collection;
import java.util.Iterator;

public class LinkQueue<V> implements Iterable<V> {

    private LinkList<V> queue;

    public LinkQueue() {
        queue = new LinkList<>();
    }

    public LinkQueue(Collection<V> values) {
        queue = new LinkList<>(values);
    }

    public void enqueue(V value) {
        queue.addLast(value);
    }

    public V dequeue() {
        return queue.removeFirst();
    }

    public V peek() {
        return queue.getFirst();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return queue.iterator();
    }
}
