package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {

        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        /* Declare second integer, double, and String variables. */
        int secondInt;
        double secondDouble;
        String secondString;

        /* Read and save an integer, double, and String to your variables.*/
        try (Scanner scan = new Scanner(System.in)) {
            secondInt = Integer.parseInt(scan.nextLine());
            secondDouble = Double.parseDouble(scan.nextLine());
            secondString = scan.nextLine();
        }

        /* Print the sum of both integer variables on a new line. */
        System.out.printf("%d\n", i + secondInt);

        /* Print the sum of the double variables on a new line. */
        System.out.printf("%.1f\n", d + secondDouble);

        /* Concatenate and print the String variables on a new line. */
        System.out.printf("%s\n", s + secondString);
    }
}
