package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedSearchTreeTest {

    private BalancedSearchTree<String, Integer> tree;

    @Before
    public void setup() {
        tree = new BalancedSearchTree<>();
    }

    @Test
    public void testCreateDefaultTree() {

        // then
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    public void testGetSingleValue() {

        // given
        tree.put("CCC", 120);
        tree.put("CCX", 130);

        // when
        Integer result = tree.get("CCX");

        //
        assertEquals(2, tree.size());
        assertEquals(new Integer(130), result);
    }

    @Test
    public void testNotGetValue() {

        // when
        Integer result = tree.get("CCC");

        //
        assertTrue(tree.isEmpty());
        assertEquals(null, result);
    }

    @Test
    public void testInsertValues() {

        // given
        String[] keys = "S E A R C H E X A M P L E".split(" ");

        // when
        for (int i = 0; i < keys.length; i++) {
            tree.put(keys[i], i);
        }

        // then
        assertEquals(10, tree.size());
        assertEquals("A", tree.min());
        assertEquals("X", tree.max());
    }

    @Test
    public void testContainsValue() {

        // given
        tree.put("CCC", 120);
        tree.put("CCX", 130);
        tree.put("CCA", 150);

        // when
        boolean result = tree.contains("CCC");

        // then
        assertTrue(result);
        assertEquals(3, tree.size());
    }

    @Test
    public void testNotContainsValue() {

        // given
        tree.put("CCC", 120);
        tree.put("CCX", 130);
        tree.put("CCA", 150);

        // when
        boolean result = tree.contains("XXX");

        // then
        assertFalse(result);
        assertEquals(3, tree.size());
    }

    @Test
    public void testIterableOverTree() {

        // given
        tree.put("4", 4);
        tree.put("3", 3);
        tree.put("1", 1);
        tree.put("2", 2);
        LinkList<Integer> result = new LinkList<>();

        // when
        for (Integer value : tree) {
            result.addLast(value);
        }

        // then
        assertEquals(tree.size(), result.size());
        assertEquals(tree.get("1"), result.getFirst());
        assertEquals(tree.get("4"), result.getLast());
    }

    @Test
    public void testIterableOverEmptyTree() {

        // given
        LinkList<Integer> result = new LinkList<>();

        // when
        for (Integer value : tree) {
            result.addLast(value);
        }

        // then
        assertEquals(tree.size(), result.size());
        assertEquals(tree.get("0"), result.getFirst());
    }

    @Test
    public void testGetKeysFromTree() {

        // given
        tree.put("Z", 120);
        tree.put("W", 130);
        tree.put("A", 150);

        // when
        LinkList<String> result = tree.keys();

        // then
        assertEquals(3, result.size());
        assertEquals("A", result.getFirst());
        assertEquals("Z", result.getLast());
    }
}
