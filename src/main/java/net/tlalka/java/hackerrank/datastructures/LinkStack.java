package net.tlalka.java.hackerrank.datastructures;

import java.util.Collection;
import java.util.Iterator;

public class LinkStack<V> implements Iterable<V> {

    private LinkList<V> stack;

    public LinkStack() {
        stack = new LinkList<>();
    }

    public LinkStack(Collection<V> values) {
        stack = new LinkList<>(values);
        stack.revers();
    }

    public void push(V value) {
        stack.addFirst(value);
    }

    public V pop() {
        return stack.removeFirst();
    }

    public V peek() {
        return stack.getFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return stack.iterator();
    }
}
