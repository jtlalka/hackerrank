package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DynamicTableTest {

    DynamicTable<String, String> table;

    @Before
    public void setup() {
        table = new DynamicTable<>();
    }

    @Test
    public void testCreateDefaultTable() {

        // then
        assertTrue(table.isEmpty());
        assertEquals(0, table.size());
    }

    @Test
    public void testCreateTableWithInitialValue() {

        // given
        String key = "Name";
        String value = "Surname";

        // when
        table = new DynamicTable<>(key, value);

        // then
        assertFalse(table.isEmpty());
        assertEquals(1, table.size());
        assertEquals(value, table.get(key));
    }

    @Test
    public void testInsertValueToTable() {

        // given
        String key = "Name";
        String value = "Surname";

        // when
        table.insert(key, value);

        // then
        assertEquals(1, table.size());
        assertEquals(value, table.get(key));
    }

    @Test
    public void testInsertTowValueToSameKey() {

        // given
        String key = "1234567";
        String value1 = "Surname1";
        String value2 = "Surname2";

        // when
        table.insert(key, value1);
        table.insert(key, value2);

        // then
        assertEquals(1, table.size());
        assertEquals(value2, table.get(key));
    }

    @Test
    public void testInsertTowValueWithSameHashCode() {

        // given
        String key1 = "Aa";
        String key2 = "BB";

        // when
        table.insert(key1, "AAA");
        table.insert(key2, "BBB");

        // then
        assertEquals(2, table.size());
        assertEquals("AAA", table.get(key1));
        assertEquals("BBB", table.get(key2));
    }

    @Test
    public void testInsertNullValueToTable() {

        // given
        String key = "Name";

        // when
        table.insert(key, null);

        // then
        assertEquals(1, table.size());
        assertEquals(null, table.get(key));
    }

    @Test
    public void testInsertNullKeyToTable() {

        // given
        String value = "Surname";

        // when
        table.insert(null, value);

        // then
        assertEquals(1, table.size());
        assertEquals(value, table.get(null));
    }

    @Test
    public void testUpdateValue() {

        // given
        table.insert("key", "init-value");

        // when
        table.update("key", "update-value");

        // then
        assertEquals(1, table.size());
        assertEquals("update-value", table.get("key"));
    }

    @Test
    public void testUpdateValueToNull() {

        // given
        table.insert("key", "init-value");

        // when
        table.update("key", null);

        // then
        assertEquals(1, table.size());
        assertEquals(null, table.get("key"));
    }

    @Test
    public void testDeleteValueByKey() {

        // given
        table.insert("AAA", "Value");
        table.insert("BBB", "Value1");

        // when
        table.delete("AAA");

        // then
        assertEquals(1, table.size());
        assertEquals("Value1", table.get("BBB"));
    }

    @Test
    public void testDeleteValueWithSameHashCode() {

        // given
        table.insert("Aa", "AAA");
        table.insert("BB", "BBB");

        // when
        table.delete("BB");

        // then
        assertEquals(1, table.size());
        assertEquals("AAA", table.get("Aa"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteInvalidKey() {

        // when
        table.delete("AAA");
    }

    @Test
    public void testConvertTableToList() {

        // given
        table.insert("key1", "value1");
        table.insert("key2", "value2");
        table.insert("key3", "value3");

        // when
        LinkList<String> result = table.toList();

        // then
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
        assertEquals(table.get("key1"), result.getFirst());
        assertEquals(table.get("key3"), result.getLast());
    }

    @Test
    public void testIterableOverTableValue() {

        // given
        table.insert("key1", "value1");
        table.insert("key2", "value2");
        table.insert("key3", "value3");
        LinkList<String> result = new LinkList<>();

        // when
        for (String value : table) {
            result.addLast(value);
        }

        // then
        for (String value : table) {
            assertEquals(value, result.removeFirst());
        }
    }
}
