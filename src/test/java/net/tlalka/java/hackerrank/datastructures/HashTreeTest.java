package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HashTreeTest {

    private HashTree<String, String> tree;

    @Before
    public void setup() {
        tree = new HashTree<>();
    }

    @Test
    public void testCreateInitialTree() {

        // then
        assertNotNull(tree);
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.getSize());
    }

    @Test
    public void testCreateTreeWithInitialValue() {

        // given
        String value = "Hello";
        String key = "Tree";

        // when
        tree = new HashTree<>(key, value);

        // then
        assertNotNull(tree);
        assertEquals(1, tree.getSize());
        assertEquals(value, tree.get(key));
    }

    @Test
    public void testInsertSingleValue() {

        // given
        String value = "Hello";
        String key = "Tree";

        // when
        tree.insert(key, value);

        // then
        assertNotNull(tree);
        assertEquals(1, tree.getSize());
        assertEquals(value, tree.get(key));
    }

    @Test
    public void testInsertTwoValues() {

        // given
        String value1 = "Hello";
        String value2 = "BRO";

        // when
        tree.insert("first", value1);
        tree.insert("second", value2);

        // then
        assertEquals(2, tree.getSize());
        assertEquals(value1, tree.get("first"));
        assertEquals(value2, tree.get("second"));
    }

    @Test
    public void testInsertTwoValueToSameKey() {

        // given
        String value1 = "Hello";
        String value2 = "BRO";

        // when
        tree.insert("key", value1);
        tree.insert("key", value2);

        // then
        assertEquals(1, tree.getSize());
        assertEquals(value2, tree.get("key"));
    }

    @Test
    public void testInsertTowValueWithSameHash() {

        // given
        String key1 = "Aa";
        String key2 = "BB";

        // when
        tree.insert(key1, "AAA");
        tree.insert(key2, "BBB");

        // then
        assertEquals(2, tree.getSize());
        assertEquals("AAA", tree.get(key1));
        assertEquals("BBB", tree.get(key2));
    }
}
