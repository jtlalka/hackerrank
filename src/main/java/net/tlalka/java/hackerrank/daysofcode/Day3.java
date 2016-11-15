package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            System.out.println((n%2 == 1 || (n >= 6 && n <= 20)) ? "Weird" : "Not Weird");
        }
    }
}
