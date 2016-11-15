package net.tlalka.java.hackerrank.interview;


import net.tlalka.java.hackerrank.interview.LinkedListCycleDetection.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListCycleDetectionTest {

    private LinkedListCycleDetection list = new LinkedListCycleDetection();

    @Test
    public void testNullArgument() {

        // when
        boolean result = list.hasCycle(null);

        // then
        assertFalse(result);
    }

    @Test
    public void testOneNodeList() {

        // given
        Node node = new Node(1, null);

        // when
        boolean result = list.hasCycle(node);

        // then
        assertFalse(result);
    }

    @Test
    public void testLongNodeList() {

        // given
        Node node = new Node(100, null);
        for (int i = 99; i > 0; i--) {
            node = new Node(i, node);
        }

        // when
        boolean result = list.hasCycle(node);

        // then
        assertFalse(result);
    }

    @Test
    public void testCycleList() {

        // given
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node4.next = node1;

        // when
        boolean result = list.hasCycle(node1);

        // then
        assertTrue(result);
    }
}
