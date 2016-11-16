package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HashMapTest {

    private HashMap<String, String> map;

    @Before
    public void setup() {
        map = new HashMap<>();
    }

    @Test
    public void testCreateDefaultMap() {

        // then
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }

    @Test
    public void testCreateMapWithInitialValue() {

        // given
        String key = "John";
        String value = "Doo";

        // when
        map = new HashMap<>(key, value);

        // then
        assertNotNull(map);
        assertFalse(map.isEmpty());
        assertEquals(value, map.get(key));
    }

    @Test
    public void testGetValueFromMap() {

        // given
        String value = "World Wide Web";
        map.insert("WWW", value);

        // when
        String result = map.get("WWW");

        // then
        assertNotNull(result);
        assertEquals(value, result);
    }

    @Test
    public void testNotGetValueFromEmptyMap() {

        // when
        String result = map.get("WWW");

        // then
        assertNull(result);
        assertTrue(map.isEmpty());
    }

    @Test
    public void testNotGetValueWithInvalidKey() {

        // given
        map.insert("WWW", "World Wide Web");

        // when
        String result = map.get("WW3");

        // then
        assertNull(result);
        assertFalse(map.isEmpty());
    }

    @Test
    public void testInsertNewValue() {

        // given
        String key = "WWW";
        String value = "World Wide Web";

        // when
        map.insert(key, value);

        // then
        assertEquals(value, map.get(key));
    }

    @Test
    public void testInsertTowValueWithSameHash() {

        // given
        String key1 = "Aa";
        String key2 = "BB";

        // when
        map.insert(key1, "AAA");
        map.insert(key2, "BBB");

        // then
        assertEquals(2, map.getSize());
        assertEquals("AAA", map.get(key1));
        assertEquals("BBB", map.get(key2));
    }

    @Test
    public void testInsertValueWithNullKey() {

        // when
        map.insert(null, "World Wide Web");

        // then
        assertEquals(1, map.getSize());
        assertEquals("World Wide Web", map.get(null));
    }

    @Test
    public void testDeleteFirstValue() {

        // given
        map.insert("WWW", "World Wide Web");
        map.insert("BrB", "Be right Back");

        // when
        map.delete("WWW");

        // then
        assertFalse(map.isEmpty());
        assertNull(map.get("WWW"));
        assertNotNull(map.get("BrB"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testNotDeleteValueWithInvalidKey() {

        // when
        map.delete("WW3");
    }

    @Test
    public void testContainsValueForKey() {

        // given
        map.insert("WWW", "World Wide Web");
        map.insert("BrB", "Be right Back");

        // when
        boolean result = map.contains("BrB");

        // then
        assertTrue(result);
        assertNotNull(map.get("WWW"));
        assertNotNull(map.get("BrB"));
    }

    @Test
    public void testNotContainsValueForInvalidKey() {

        // given
        map.insert("WWW", "World Wide Web");
        map.insert("BrB", "Be right Back");

        // when
        boolean result = map.contains("BrB++");

        // then
        assertFalse(result);
        assertNotNull(map.get("WWW"));
        assertNotNull(map.get("BrB"));
    }

    @Test
    public void testConvertMapToList() {

        // given
        map.insert("key1", "value1");
        map.insert("key2", "value2");
        map.insert("key3", "value3");

        // when
        LinkList<String> result = map.toList();

        // then
        assertFalse(result.isEmpty());
        assertEquals(3, result.getSize());
        assertEquals(map.get("key1"), result.getFirst());
        assertEquals(map.get("key3"), result.getLast());
    }

    @Test
    public void testIterableOverMapValue() {

        // given
        map.insert("key1", "value1");
        map.insert("key2", "value2");
        map.insert("key3", "value3");
        LinkList<String> result = new LinkList<>();

        // when
        for (String value : map) {
            result.addLast(value);
        }

        // then
        for (String value : map) {
            assertEquals(value, result.removeFirst());
        }
    }
}
