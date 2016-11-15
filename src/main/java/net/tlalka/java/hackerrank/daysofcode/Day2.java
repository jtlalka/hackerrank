package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble();
        int tipPercent = scan.nextInt();
        int taxPercent = scan.nextInt();
        scan.close();

        // Write your calculation code here.
        double tip = mealCost * tipPercent / 100;
        double tax = mealCost * taxPercent / 100;
        double total = mealCost + tip + tax;

        // cast the result of the rounding operation to an int and save it as totalCost
        long totalCost = Math.round(total);

        // Print your result
        System.out.printf("The total meal cost is %d dollars.\n", totalCost);
    }
}
