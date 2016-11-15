package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private BinaryTree<String> tree;

    @Before
    public void setup() {
        tree = new BinaryTree<>();
    }

    @Test
    public void testCreateEmptyTree() {

        // then
        assertNotNull(tree);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testCreateTreeWithInitialValue() {

        // given
        String value = "Hello";

        // when
        tree = new BinaryTree<>(1, value);

        // then
        assertNotNull(tree);
        assertEquals(1, tree.getSize());
        assertEquals(value, tree.get(1));
    }

    @Test
    public void testGetValueFromTree() {

        // given
        tree.insert(1, "Value");

        // when
        String result = tree.get(1);

        // then
        assertNotNull(tree);
        assertEquals(1, tree.getSize());
        assertEquals("Value", result);
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
        tree.insert(1, null);

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
        tree.insert(5, value);

        // then
        assertEquals(1, tree.getSize());
        assertEquals(value, tree.get(5));
    }

    @Test
    public void testInsertTwoValues() {

        // given
        String value1 = "Hello";
        String value2 = "BRO";

        // when
        tree.insert(1, value1);
        tree.insert(2, value2);

        // then
        assertEquals(2, tree.getSize());
        assertEquals(value1, tree.get(1));
        assertEquals(value2, tree.get(2));
    }

    @Test
    public void testInsertTwoValueToSameId() {

        // given
        String value1 = "Hello";
        String value2 = "BRO";

        // when
        tree.insert(5, value1);
        tree.insert(5, value2);

        // then
        assertEquals(1, tree.getSize());
        assertEquals(value2, tree.get(5));
    }

    @Test
    public void testContainsId() {

        // given
        tree.insert(124, "SimpleTest");
        tree.insert(125, "SimpleValue");

        // when
        boolean result = tree.contains(124);

        // then
        assertTrue(result);
        assertEquals(2, tree.getSize());
    }

    @Test
    public void testNotContainsId() {

        // given
        tree.insert(124, "SimpleTest");
        tree.insert(125, "SimpleValue");

        // when
        boolean result = tree.contains(1000);

        // then
        assertFalse(result);
        assertEquals(2, tree.getSize());
    }

    @Test
    public void testNotContainsIdInEmptyTree() {

        // when
        boolean result = tree.contains(1000);

        // then
        assertFalse(result);
    }

    @Test
    public void testConvertTreeToOrderList() {

        // given
        tree.insert(4, "4");
        tree.insert(3, "3");
        tree.insert(1, "1");
        tree.insert(2, "2");
        tree.insert(4, "4!");

        // when
        LinkList<String> result = tree.toList();

        // then
        assertNotNull(result);
        assertEquals(4, result.getSize());
        assertEquals("1", result.getFirst());
        assertEquals("4!", result.getLast());
    }

    @Test
    public void testIterableOverTree() {

        // given
        tree.insert(4, "4");
        tree.insert(3, "3");
        tree.insert(1, "1");
        tree.insert(2, "2");
        tree.insert(4, "4!");
        LinkList<String> result = new LinkList<>();

        // when
        for (String value : tree) {
            result.addLast(value);
        }

        // then
        assertEquals(tree.getSize(), result.getSize());
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
        assertEquals(tree.getSize(), result.getSize());
        assertEquals(tree.get(1), result.getFirst());
    }
}
