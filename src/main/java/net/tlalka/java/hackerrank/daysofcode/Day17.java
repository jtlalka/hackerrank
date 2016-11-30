package net.tlalka.java.hackerrank.daysofcode;

public class Day17 {

    private static class Calculator {
        public int power(int p, int n) {
            if (p < 0 || n < 0) {
                throw new IllegalArgumentException("n and p should be non-negative");
            } else {
                return (int) Math.pow(p, n);
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(new Calculator().power(5, -3));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
