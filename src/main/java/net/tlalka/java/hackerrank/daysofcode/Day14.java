package net.tlalka.java.hackerrank.daysofcode;

import java.util.Arrays;

public class Day14 {

    private static class Difference {
        private int[] elements;
        public int maximumDifference;

        public Difference(int[] elements) {
            this.elements = elements;
        }

        public void computeDifference() {
            int min = Arrays.stream(elements).min().orElse(1);
            int max = Arrays.stream(elements).max().orElse(100);
            maximumDifference = Math.abs(min - max);
        }
    }

    public static void main(String[] args) {
        Difference difference = new Difference(new int[]{1, 3, 6, -2, 0});
        difference.computeDifference();
        System.out.print(difference.maximumDifference);
    }
}
