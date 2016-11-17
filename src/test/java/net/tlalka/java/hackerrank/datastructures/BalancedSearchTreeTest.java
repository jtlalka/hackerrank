package net.tlalka.java.hackerrank.datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BalancedSearchTreeTest {

    private BalancedSearchTree<String, Integer> tree;

    @Before
    public void setup() {
        tree = new BalancedSearchTree<>();
    }

    @After
    public void check() {
        assertTrue(tree.checkTree());
    }

    @Test
    public void testCreateDefaultTree() {

        // then
        assertNotNull(tree);
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    public void testGetValueFromEmptyTree() {

        // when
        Integer result = tree.get("AAA");

        // then
        assertNull(result);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testGetNullValueFromTree() {

        // given
        tree.put("AAA", null);

        // when
        Integer result = tree.get("AAA");

        // then
        assertNull(result);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testNotGetValueWithWrongKey() {

        // given
        tree.put("AAA", 1234);

        // when
        Integer result = tree.get("CCC");

        // then
        assertEquals(null, result);
        assertEquals(1, tree.size());
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
        assertEquals(4, tree.height());
    }

    @Test
    public void testInsertTwoValueToSameKey() {

        // given
        Integer value1 = 124;
        Integer value2 = 512;

        // when
        tree.put("AA", value1);
        tree.put("AA", value2);

        // then
        assertEquals(1, tree.size());
        assertEquals(value2, tree.get("AA"));
    }

    @Test
    public void testDeleteSingleItem() {

        // given
        tree.put("AAA", 1000);
        tree.put("BBB", 2000);

        // when
        tree.delete("AAA");

        // then
        assertEquals(1, tree.size());
        assertEquals(new Integer(2000), tree.get("BBB"));
    }

    @Test
    public void testDeleteAllItems() {

        // given
        String[] keys = "S E A R C H E X A M P L E".split(" ");
        for (int i = 0; i < keys.length; i++) {
            tree.put(keys[i], i);
        }

        // when
        for (String key : keys) {
            tree.delete(key);
        }

        // then
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertEquals(null, tree.min());
        assertEquals(null, tree.max());
        assertEquals(0, tree.height());
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
    public void testGetValuesFromTree() {

        // given
        tree.put("4", 4000);
        tree.put("3", 3000);
        tree.put("1", 1000);
        tree.put("2", 2000);
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
