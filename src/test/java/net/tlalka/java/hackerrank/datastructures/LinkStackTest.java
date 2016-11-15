package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LinkStackTest {

    private LinkStack<Long> stack;

    @Before
    public void setup() {
        stack = new LinkStack<>();
    }

    @Test
    public void testCreateEmptyStack() {

        // then
        assertNotNull(stack);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testCreateQueueFromCollection() {

        // when
        stack = new LinkStack<>(Arrays.asList(122L, 123L, 124L));

        // then
        assertEquals(3, stack.getSize());
        assertEquals(new Long(124L), stack.pop());
        assertEquals(new Long(123L), stack.pop());
        assertEquals(new Long(122L), stack.pop());
    }

    @Test
    public void testAddElementToStack() {

        // given
        Long value = 122L;

        // when
        stack.push(value);

        // then
        assertEquals(1, stack.getSize());
        assertEquals(value, stack.peek());
    }

    @Test
    public void testPeekElementFromStack() {

        // given
        stack = new LinkStack<>(Arrays.asList(122L, 123L, 124L));

        // when
        Long result = stack.peek();

        // then
        assertEquals(3, stack.getSize());
        assertEquals(new Long(124L), result);
    }

    @Test
    public void testRemoveElementFromStack() {

        // given
        stack = new LinkStack<>(Arrays.asList(122L, 123L, 124L));

        // when
        Long result = stack.pop();

        // then
        assertEquals(2, stack.getSize());
        assertEquals(new Long(124L), result);
    }
}
