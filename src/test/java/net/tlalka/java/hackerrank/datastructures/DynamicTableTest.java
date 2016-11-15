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
        assertEquals(0, table.getSize());
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
        assertEquals(1, table.getSize());
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
        assertEquals(1, table.getSize());
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
        assertEquals(1, table.getSize());
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
        assertEquals(2, table.getSize());
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
        assertEquals(1, table.getSize());
        assertEquals(null, table.get(key));
    }

    @Test
    public void testInsertNullKeyToTable() {

        // given
        String value = "Surname";

        // when
        table.insert(null, value);

        // then
        assertEquals(1, table.getSize());
        assertEquals(value, table.get(null));
    }

    @Test
    public void testInsertTowNullKeyToTable() {

        // given
        String value1 = "Surname1";
        String value2 = "Surname2";

        // when
        table.insert(null, value1);
        table.insert(null, value2);

        // then
        assertEquals(1, table.getSize());
        assertEquals(value2, table.get(null));
    }

    @Test
    public void testDeleteValueByKey() {

        // given
        table.insert("AAA", "Value");
        table.insert("BBB", "Value1");

        // when
        table.delete("AAA");

        // then
        assertEquals(1, table.getSize());
        assertEquals("Value1", table.get("BBB"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteInvalidKey() {

        // when
        table.delete("AAA");
    }
}