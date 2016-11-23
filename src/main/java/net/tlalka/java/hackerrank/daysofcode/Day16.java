package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;

public class Day16 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Integer.parseInt(scanner.next()));
        } catch (NumberFormatException ignore) {
            System.out.println("Bad String");
        }
    }
}
