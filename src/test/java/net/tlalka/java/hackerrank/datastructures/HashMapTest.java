package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

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
        map.put("WWW", value);

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
        map.put("WWW", "World Wide Web");

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
        map.put(key, value);

        // then
        assertEquals(value, map.get(key));
    }

    @Test
    public void testInsertTowValueWithSameHash() {

        // given
        String key1 = "Aa";
        String key2 = "BB";

        // when
        map.put(key1, "AAA");
        map.put(key2, "BBB");

        // then
        assertEquals(2, map.size());
        assertEquals("AAA", map.get(key1));
        assertEquals("BBB", map.get(key2));
    }

    @Test
    public void testInsertValueWithNullKey() {

        // when
        map.put(null, "World Wide Web");

        // then
        assertEquals(1, map.size());
        assertEquals("World Wide Web", map.get(null));
    }

    @Test
    public void testDeleteFirstValue() {

        // given
        map.put("WWW", "World Wide Web");
        map.put("BrB", "Be right Back");

        // when
        map.delete("WWW");

        // then
        assertFalse(map.isEmpty());
        assertNull(map.get("WWW"));
        assertNotNull(map.get("BrB"));
    }

    @Test
    public void testContainsValueForKey() {

        // given
        map.put("WWW", "World Wide Web");
        map.put("BrB", "Be right Back");

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
        map.put("WWW", "World Wide Web");
        map.put("BrB", "Be right Back");

        // when
        boolean result = map.contains("BrB++");

        // then
        assertFalse(result);
        assertEquals(2, map.size());
    }

    @Test
    public void testConvertMapToList() {

        // given
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        // when
        LinkList<String> result = map.values();

        // then
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
        assertEquals(map.get("key1"), result.getFirst());
        assertEquals(map.get("key3"), result.getLast());
    }

    @Test
    public void testIterableOverMapValue() {

        // given
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
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
