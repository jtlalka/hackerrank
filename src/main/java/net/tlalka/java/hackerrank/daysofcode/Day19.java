package net.tlalka.java.hackerrank.daysofcode;

public class Day19 {

    private interface AdvancedArithmetic{
        int divisorSum(int n);
    }

    private static class Calculator implements AdvancedArithmetic {

        @Override
        public int divisorSum(int n) {
            int sum = 0;
            for (int i = n; i > 0; i--) {
                if (n % i == 0) {
                    sum += i;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        AdvancedArithmetic myCalculator = new Calculator();
        System.out.println(myCalculator.divisorSum(6));
    }
}
