package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    public void testGetSingleValue() {

        // given
        tree.insert("KEY", "VALUE");

        // when
        String result = tree.get("KEY");

        // then
        assertEquals(1, tree.getSize());
        assertEquals("VALUE", result);
    }

    @Test
    public void testNotGetValueForInvalidKey() {

        // when
        String result = tree.get("KEY");

        // then
        assertEquals(0, tree.getSize());
        assertEquals(null, result);
    }

    @Test
    public void testInsertSingleValue() {

        // given
        String value = "Hello";
        String key = "Tree";

        // when
        tree.insert(key, value);

        // then
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

    @Test
    public void testDeleteValue() {

        // given
        tree.insert("111", "AAA");
        tree.insert("222", "BBB");
        tree.insert("333", "CCC");

        // when
        tree.delete("222");

        // then
        assertEquals(2, tree.getSize());
        assertFalse(tree.contains("222"));
    }

    @Test
    public void testDeleteValueWithSameHashCode() {

        // given
        tree.insert("Aa", "AAA");
        tree.insert("BB", "BBB");

        // when
        tree.delete("BB");

        // then
        assertEquals(1, tree.getSize());
        assertFalse(tree.contains("BB"));
    }

    @Test
    public void testContainsValue() {

        // given
        tree.insert("first", "value1");
        tree.insert("second", "value2");

        // when
        boolean result = tree.contains("second");

        // then
        assertTrue(result);
        assertEquals(2, tree.getSize());
    }

    @Test
    public void testContainsValueWithSameHash() {

        // given
        tree.insert("Aa", "value1");
        tree.insert("BB", "value2");

        // when
        boolean result = tree.contains("BB");

        // then
        assertTrue(result);
        assertEquals(2, tree.getSize());
    }

    @Test
    public void testNotContainsInvalidValue() {

        // given
        tree.insert("first", "value1");
        tree.insert("second", "value2");

        // when
        boolean result = tree.contains("second-invalid");

        // then
        assertFalse(result);
        assertEquals(2, tree.getSize());
    }

    @Test
    public void testConvertTreeToList() {

        // given
        tree.insert("key1", "value1");
        tree.insert("key2", "value2");
        tree.insert("key3", "value3");

        // when
        LinkList<String> result = tree.toList();

        // then
        assertFalse(result.isEmpty());
        assertEquals(3, result.getSize());
        assertEquals(tree.get("key1"), result.getFirst());
        assertEquals(tree.get("key3"), result.getLast());
    }

    @Test
    public void testIterableOverTreeValue() {

        // given
        tree.insert("key1", "value1");
        tree.insert("key2", "value2");
        tree.insert("key3", "value3");
        LinkList<String> result = new LinkList<>();

        // when
        for (String value : tree) {
            result.addLast(value);
        }

        // then
        for (String value : tree) {
            assertEquals(value, result.removeFirst());
        }
    }
}
