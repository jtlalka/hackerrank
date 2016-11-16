package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

    private BinarySearchTree<String> tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree<>();
    }

    @Test
    public void testCreateEmptyTree() {

        // then
        assertNotNull(tree);
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    public void testGetValueFromEmptyTree() {

        // when
        String result = tree.get(1);

        // then
        assertNotNull(tree);
        assertNull(result);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testGetNullValueFromTree() {

        // given
        tree.put(1, null);

        // when
        String result = tree.get(1);

        // then
        assertNotNull(tree);
        assertNull(result);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testInsertSingleValue() {

        // given
        String value = "Hello";

        // when
        tree.put(5, value);

        // then
        assertEquals(1, tree.size());
        assertEquals(value, tree.get(5));
    }

    @Test
    public void testInsertTwoValueToSameKey() {

        // given
        String value1 = "Hello";
        String value2 = "BRO";

        // when
        tree.put(5, value1);
        tree.put(5, value2);

        // then
        assertEquals(1, tree.size());
        assertEquals(value2, tree.get(5));
    }

    @Test
    public void testDeleteItemFromTree() {

        // given
        tree.put(4, "4");
        tree.put(3, "3");
        tree.put(1, "1");
        tree.put(2, "2");
        tree.put(4, "4!");

        // when
        tree.delete(3);

        // then
        assertEquals(1, tree.min());
        assertEquals(4, tree.max());
        assertEquals(3, tree.size());
        assertEquals("4!", tree.get(4));
    }

    @Test
    public void testContainsKey() {

        // given
        tree.put(124, "SimpleTest");
        tree.put(125, "SimpleValue");

        // when
        boolean result = tree.contains(124);

        // then
        assertTrue(result);
        assertEquals(2, tree.size());
    }

    @Test
    public void testContainsInvalidKey() {

        // given
        tree.put(124, "SimpleTest");
        tree.put(125, "SimpleValue");

        // when
        boolean result = tree.contains(1000);

        // then
        assertFalse(result);
        assertEquals(2, tree.size());
    }

    @Test
    public void testConvertTreeToOrderList() {

        // given
        tree.put(4, "4");
        tree.put(3, "3");
        tree.put(1, "1");
        tree.put(2, "2");
        tree.put(4, "4!");

        // when
        LinkList<String> result = tree.values();

        // then
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals("1", result.getFirst());
        assertEquals("4!", result.getLast());
    }

    @Test
    public void testIterableOverTree() {

        // given
        tree.put(4, "4");
        tree.put(3, "3");
        tree.put(1, "1");
        tree.put(2, "2");
        tree.put(4, "4!");
        LinkList<String> result = new LinkList<>();

        // when
        for (String value : tree) {
            result.addLast(value);
        }

        // then
        assertEquals(tree.size(), result.size());
        assertEquals(tree.get(1), result.getFirst());
        assertEquals(tree.get(4), result.getLast());
    }

    @Test
    public void testIterableOverEmptyTree() {

        // given
        LinkList<String> result = new LinkList<>();

        // when
        for (String value : tree) {
            result.addLast(value);
        }

        // then
        assertEquals(tree.size(), result.size());
        assertEquals(tree.get(0), result.getFirst());
    }

    @Test
    public void testGetKeysFromTree() {

        // given
        tree.put(1, "120");
        tree.put(2, "130");
        tree.put(4, "150");

        // when
        LinkList<Integer> result = tree.keys();

        // then
        assertEquals(3, result.size());
        assertEquals(new Integer(1), result.getFirst());
        assertEquals(new Integer(4), result.getLast());
    }
}
