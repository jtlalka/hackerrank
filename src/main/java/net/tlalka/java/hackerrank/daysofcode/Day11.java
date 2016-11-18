package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;

public class Day11 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int matrix[][] = new int[6][6];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            System.out.println(getMaxHourglassValue(matrix));
        }
    }

    private static int getMaxHourglassValue(int[][] matrix) {
        int size = matrix.length;
        int hourglass = 3;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= size - hourglass; i++) {
            for (int j = 0; j <= size - hourglass; j++) {
                max = Math.max(max, getHourglassValue(matrix, i, j));
            }
        }
        return max;
    }

    private static int getHourglassValue(int m[][], int i, int j) {
        return m[i][j] + m[i][j + 1] + m[i][j + 2] + m[i + 1][j + 1] + m[i + 2][j] + m[i + 2][j + 1] + m[i + 2][j + 2];
    }
}
