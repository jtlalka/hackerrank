package net.tlalka.java.hackerrank.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Calculator {

    public static final UnaryOperator<Integer> factorial = x -> (x == 0) ? 1 : x * Calculator.factorial.apply(x - 1);

    public static final BinaryOperator<Integer> pow = (p, n) -> (n == 0) ? 1 : p * Calculator.pow.apply(p, n - 1);
}
