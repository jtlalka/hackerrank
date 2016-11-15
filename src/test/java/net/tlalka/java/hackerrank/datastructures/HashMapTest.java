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
        map.insert("WWW", value);

        // when
        String result = map.get("WWW");

        // then
        assertNotNull(result);
        assertEquals(value, result);
    }

    @Test
    public void testNotGetValueEmptyMap() {

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNotInsertValueWithInvalidKey() {

        // when
        map.insert(null, "World Wide Web");
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

    @Test
    public void testNotDeleteValueWithInvalidKey() {

        // given
        map.insert("WWW", "World Wide Web");
        map.insert("BrB", "Be right Back");

        // when
        map.delete("WW3");

        // then
        assertFalse(map.isEmpty());
        assertNotNull(map.get("WWW"));
        assertNotNull(map.get("BrB"));
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
}
