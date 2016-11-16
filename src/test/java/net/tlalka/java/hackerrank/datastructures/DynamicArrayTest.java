package net.tlalka.java.hackerrank.datastructures;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;

public class DynamicArrayTest {

    private DynamicArray<Integer> array;

    private int length = 20;

    private int vector = 10;

    @Before
    public void setup() {
        array = new DynamicArray<>(length, vector);
    }

    @Test
    public void testCreateDefaultArray() {

        // when
        array = new DynamicArray<>();

        // then
        assertNotNull(array);
        assertTrue(array.isEmpty());
    }

    @Test
    public void testCreateCustomArray() {

        // when
        array = new DynamicArray<>(10, 10000);

        // then
        assertNotNull(array);
        assertTrue(array.isEmpty());
    }

    @Test
    public void testCreateArrayFromCollection() {

        // given
        List<Integer> collection = Arrays.asList(1, 2, 3, 4, 4, 5, 6);

        // when
        array = new DynamicArray<>(collection);

        // then
        assertNotNull(array);
        assertEquals(collection.size(), array.size());
        assertEquals(collection.get(2), array.get(2));
        assertEquals(collection.get(5), array.get(5));
    }

    @Test
    public void testGetElement() {

        // given
        Integer value1 = 112244;
        array.insert(value1);

        // when
        Integer result = array.get(0);

        // then
        assertEquals(1, array.size());
        assertEquals(value1, result);
    }

    @Test
    public void testGetNullElement() {

        // given
        array.insert(101);
        array.update(0, null);

        // when
        Integer result = array.get(0);

        // then
        assertEquals(1, array.size());
        assertEquals(null, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNotExistingElement() {

        // when
        array.get(length + vector);
    }

    @Test
    public void testInsertSingleElement() {

        // given
        Integer value = anyInt();

        // when
        array.insert(value);

        // then
        assertEquals(1, array.size());
        assertEquals(value, array.get(0));
    }

    @Test
    public void testInsertTwoElements() {

        // given
        Integer value1 = anyInt();
        Integer value2 = anyInt();

        // when
        array.insert(value1);
        array.insert(value2);

        // then
        assertEquals(2, array.size());
        assertEquals(value1, array.get(0));
        assertEquals(value2, array.get(1));
    }

    @Test
    public void testInsertNullElement() {

        // when
        array.insert(null);

        // then
        assertEquals(1, array.size());
        assertEquals(null, array.get(0));
    }

    @Test
    public void testInsertListOfElements() {

        // given
        List<Integer> list = IntStream
                .range(0, length + 3 * vector)
                .boxed().collect(Collectors.toList());

        // when
        for (Integer value : list) {
            array.insert(value);
        }

        // then
        for (Integer value : list) {
            assertEquals(value, array.get(value));
        }
    }

    @Test
    public void testUpdateElement() {

        // given
        array.insert(124);
        array.insert(255);

        // when
        array.update(1, 0);

        // then
        assertEquals(2, array.size());
        assertEquals(new Integer(0), array.get(1));
    }

    @Test
    public void testDeleteElement() {

        // given
        array.insert(124);
        array.insert(255);
        array.insert(512);

        // when
        array.delete(1);

        // then
        assertEquals(2, array.size());
        assertEquals(new Integer(124), array.get(0));
        assertEquals(new Integer(512), array.get(1));
    }

    @Test
    public void testCheckResizableOfArray() {

        // given
        int fiveVectors = 5 * vector;

        // when
        for (int i = 0; i < fiveVectors; i++) {
            array.insert(i);
        }

        // then
        assertEquals(fiveVectors, array.size());
        assertEquals(new Integer(fiveVectors - 1), array.get(fiveVectors - 1));
    }

    @Test
    public void testConvertArrayToList() {

        // given
        array.insert(5);
        array.insert(10);
        array.insert(15);

        // when
        LinkList<Integer> result = array.toList();

        // then
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
        assertEquals(array.get(0), result.getFirst());
        assertEquals(array.get(2), result.getLast());
    }
}
