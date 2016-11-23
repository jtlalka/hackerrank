package net.tlalka.java.hackerrank.daysofcode;

import java.util.Arrays;

public class Day15 {

    private static Node head;

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node insert(Node head, int data) {
        if (head == null) head = new Node(data);
        else head.next = insert(head.next, data);
        return head;
    }

    public static void display(Node node) {
        if (node != null) {
            System.out.print(node.data + "  ");
            display(node.next);
        }
    }

    public static void main(String args[]) {
        Arrays.asList(2, 3, 4, 1).forEach(v -> head = insert(head, v));
        display(head);
    }
}
