package net.tlalka.java.hackerrank.daysofcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day10 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(binary(scanner.nextInt()));
        }
    }

    public static int binary(int n) {
        return Arrays.stream(Integer.toBinaryString(n).split("0+"))
                .max(Comparator.naturalOrder())
                .orElse("")
                .length();
    }
}
