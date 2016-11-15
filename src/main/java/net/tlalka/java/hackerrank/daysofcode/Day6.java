package net.tlalka.java.hackerrank.daysofcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day6 {

    public static void main(String[] args) {
        List<String> data = readInputData();

        data.forEach(line -> {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            line.chars().forEach(ch -> {
                if((even.length() + odd.length()) % 2 == 0) {
                    even.append((char) ch);
                } else {
                    odd.append((char) ch);
                }
            });
            System.out.println(even.append(" ").append(odd).toString());
        });
    }

    private static List<String> readInputData() {
        List<String> data = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            IntStream
                    .range(1, Integer.parseInt(scanner.nextLine()) + 1)
                    .forEach(i -> data.add(scanner.nextLine()));
        }
        return data;
    }
}
