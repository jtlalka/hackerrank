package net.tlalka.java.hackerrank.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StacksBalancedBracketsTest {

    private StacksBalancedBrackets stack;

    @Before
    public void setup() {
        stack = new StacksBalancedBrackets();
    }

    @Test
    public void testEmptyExpression() {

        // when
        boolean result = stack.isBalanced("");

        // then
        assertTrue(result);
    }

    @Test
    public void testSingleTokenExpression() {

        // given
        String expression = "[";

        // when
        boolean result = stack.isBalanced(expression);

        // then
        assertEquals(false, result);
    }

    @Test
    public void testBalancedSingleExpression() {

        // given
        String expression = "[]";

        // when
        boolean result = stack.isBalanced(expression);

        // then
        assertEquals(true, result);
    }

    @Test
    public void testBalancedComplexExpression() {

        // given
        String expression = "{{}([])({{}})}()";

        // when
        boolean result = stack.isBalanced(expression);

        // then
        assertEquals(true, result);
    }

    @Test
    public void testNotBalancedComplexExpression() {

        // given
        String expression = "{{}([)({{}})}()";

        // when
        boolean result = stack.isBalanced(expression);

        // then
        assertEquals(false, result);
    }
}
