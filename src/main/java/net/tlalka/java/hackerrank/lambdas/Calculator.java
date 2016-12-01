package net.tlalka.java.hackerrank.lambdas;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    public static final UnaryOperator<Integer> negative = x -> -x;

    public static final UnaryOperator<Integer> factorial = x -> (x == 0) ? 1 : x * Calculator.factorial.apply(x - 1);

    public static final BinaryOperator<Integer> pow = (p, n) -> (n == 0) ? 1 : p * Calculator.pow.apply(p, n - 1);

    public static List<Integer> divisor(int n) {
        return IntStream
                .range(1, n + 1)
                .filter(v -> (n % v) == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
