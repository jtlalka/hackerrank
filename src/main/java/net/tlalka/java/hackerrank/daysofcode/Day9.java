package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;

public class Day9 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(factorial(scanner.nextInt()));
        }
    }

    public static int factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }
}
