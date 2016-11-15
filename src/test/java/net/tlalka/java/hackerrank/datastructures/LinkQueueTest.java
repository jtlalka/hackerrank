package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LinkQueueTest {

    private LinkQueue<Long> queue;

    @Before
    public void setup() {
        queue = new LinkQueue<>();
    }

    @Test
    public void testCreateEmptyQueue() {

        // then
        assertNotNull(queue);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testCreateQueueFromCollection() {

        // when
        queue = new LinkQueue<>(Arrays.asList(122L, 123L, 124L));

        // then
        assertEquals(3, queue.getSize());
        assertEquals(new Long(122L), queue.dequeue());
        assertEquals(new Long(123L), queue.dequeue());
        assertEquals(new Long(124L), queue.dequeue());
    }

    @Test
    public void testAddElementToQueue() {

        // given
        Long value = 122L;

        // when
        queue.enqueue(value);

        // then
        assertEquals(1, queue.getSize());
        assertEquals(value, queue.peek());
    }

    @Test
    public void testPeekElementFromQueue() {

        // given
        queue = new LinkQueue<>(Arrays.asList(122L, 123L, 124L));

        // when
        Long result = queue.peek();

        // then
        assertEquals(3, queue.getSize());
        assertEquals(new Long(122L), result);
    }

    @Test
    public void testDequeueElementFromQueue() {

        // given
        queue = new LinkQueue<>(Arrays.asList(122L, 123L, 124L));

        // when
        Long result = queue.dequeue();

        // then
        assertEquals(2, queue.getSize());
        assertEquals(new Long(122L), result);
    }
}
