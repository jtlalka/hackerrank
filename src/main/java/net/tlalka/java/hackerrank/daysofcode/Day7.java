package net.tlalka.java.hackerrank.daysofcode;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day7 {

    public static void main(String[] args) {
        List<Integer> numbers = readInputData();
        Collections.reverse(numbers);
        numbers.forEach(n -> System.out.print(n + " "));
    }

    private static List<Integer> readInputData() {
        try (Scanner scanner = new Scanner(System.in)) {
            return IntStream
                    .range(1, scanner.nextInt() + 1)
                    .map(i -> scanner.nextInt())
                    .boxed()
                    .collect(Collectors.toList());
        }
    }
}
