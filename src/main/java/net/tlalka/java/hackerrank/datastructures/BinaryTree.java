package net.tlalka.java.hackerrank.datastructures;

import java.util.Iterator;

public class BinaryTree<E> implements Iterable<E> {

    private class Node {

        private E entry;
        private int index;
        private Node left;
        private Node right;

        public Node(int id, E entry) {
            this.entry = entry;
            this.index = id;
            this.left = null;
            this.right = null;
        }

        public E getEntry(int id) {
            if (index == id) {
                return entry;
            } else if (index > id && left != null) {
                return left.getEntry(id);
            } else if (index < id && right != null) {
                return right.getEntry(id);
            } else {
                return null;
            }
        }

        public boolean insert(int id, E entry) {
            if (index == id) {
                this.entry = entry;
                return false;
            } else if (index > id) {
                return left == null && setupLeft(new Node(id, entry)) || left.insert(id, entry);
            } else {
                return right == null && setupRight(new Node(id, entry)) || right.insert(id, entry);
            }
        }

        public LinkList<E> getListInOrder() {
            LinkList<E> inOrder = new LinkList<>();
            if (left != null) {
                inOrder.addLast(left.getListInOrder());
            }
            inOrder.addLast(entry);
            if (right != null) {
                inOrder.addLast(right.getListInOrder());
            }
            return inOrder;
        }

        private boolean setupLeft(Node node) {
            return (left = node) != null;
        }

        private boolean setupRight(Node node) {
            return (right = node) != null;
        }
    }

    private Node head;

    private int size;

    public BinaryTree() {
        this.head = null;
        this.size = 0;
    }

    public BinaryTree(int id, E entry) {
        this.insert(id, entry);
    }

    public E get(int id) {
        return head != null ? head.getEntry(id) : null;
    }

    public void insert(int id, E entry) {
        if (head == null) {
            head = new Node(id, entry);
            size++;
        } else {
            if (head.insert(id, entry)) {
                size++;
            }
        }
    }

    public boolean contains(int id) {
        return head != null && head.getEntry(id) != null;
    }

    public LinkList<E> toList() {
        return head != null ? head.getListInOrder() : new LinkList<>();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return this.toList().iterator();
    }
}
