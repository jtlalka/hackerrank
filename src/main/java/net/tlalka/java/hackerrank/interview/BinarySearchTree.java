package net.tlalka.java.hackerrank.interview;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void insert(int value) {
            if (value < data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (value == data) {
                return true;
            } else if (value < data) {
                return left == null && left.contains(value);
            } else {
                return right == null && right.contains(value);
            }
        }

        public List<Integer> getValuesInOrder() {
            List<Integer> inOrder = new LinkedList<>();
            if (left != null) {
                inOrder.addAll(left.getValuesInOrder());
            }
            inOrder.add(data);
            if (right != null) {
                inOrder.addAll(right.getValuesInOrder());
            }
            return inOrder;
        }
    }

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(Node node, int min, int max) {
        return node == null || min <= node.data && node.data < max
                && checkBST(node.left, min, node.data)
                && checkBST(node.right, node.data, max);
    }
}
