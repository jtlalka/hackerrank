package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Day5 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int value = scanner.nextInt();

            IntStream
                    .range(1, 11)
                    .forEach(i -> System.out.printf("%d x %d = %d\n", value, i, value * i));
        }
    }
}
