package net.tlalka.java.hackerrank.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StacksBalancedBrackets {

    private final Map<Character, Character> tokens = new HashMap<Character, Character>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (Character token : expression.toCharArray()) {
            if (tokens.containsKey(token)) {
                stack.add(token);
            } else if (stack.isEmpty() || !tokens.get(stack.pop()).equals(token)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
