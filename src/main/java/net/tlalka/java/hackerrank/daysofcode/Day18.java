package net.tlalka.java.hackerrank.daysofcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day18 {

    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new LinkedList<>();

    private void pushCharacter(char c) {
        stack.push(c);
    }

    private char popCharacter() {
        return stack.pop();
    }

    private void enqueueCharacter(char c) {
        queue.add(c);
    }

    private char dequeueCharacter() {
        return queue.remove();
    }

    public static void main(String[] args) {
        Day18 p = new Day18();
        char[] s = "reviver".toCharArray();

        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                System.out.println("Not palindrome");
                return;
            }
        }
        System.out.println("Palindrome");
    }
}
