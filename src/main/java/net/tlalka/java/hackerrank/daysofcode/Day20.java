package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Day20 {

    public static int bubbleSort(int[] array) {
        int length = array.length;
        int swaps = 0;
        boolean inProgress = true;

        while (inProgress) {
            inProgress = false;

            for (int i = 0; i < length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    inProgress = true;
                    swap(array, i, i + 1);
                    swaps++;
                }
            }
        }
        return swaps;
    }

    private static void swap(int[] array, int i, int j) {
        int n = array[j];
        array[j] = array[i];
        array[i] = n;
    }

    public static void main(String[] args) {
        int[] array = readInputData();
        int swaps = bubbleSort(array);

        System.out.printf("Array is sorted in %d swaps.\n", swaps);
        System.out.printf("First Element: %d\n", array[0]);
        System.out.printf("Last Element: %d\n", array[array.length - 1]);
    }

    private static int[] readInputData() {
        try (Scanner scanner = new Scanner(System.in)) {
            return IntStream
                    .range(1, scanner.nextInt() + 1)
                    .map(i -> scanner.nextInt())
                    .toArray();
        }
    }
}
