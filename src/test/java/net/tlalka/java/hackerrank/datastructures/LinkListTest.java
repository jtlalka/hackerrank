package net.tlalka.java.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;

public class LinkListTest {

    private LinkList<Integer> list;

    @Before
    public void setup() {
        this.list = new LinkList<>();
    }

    @Test
    public void testCreateEmptyList() {

        // then
        assertNotNull(list);
        assertTrue(list.isEmpty());
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    @Test
    public void testCreateListWithInitialValue() {

        // given
        Integer value = anyInt();

        // when
        list = new LinkList<>(value);

        // then
        assertNotNull(list);
        assertEquals(1, list.getSize());
        assertEquals(value, list.getFirst());
        assertEquals(value, list.getLast());
    }

    @Test
    public void testCreateListFromCollection() {

        // given
        List<Integer> collection = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        list = new LinkList<>(collection);

        // then
        assertNotNull(list);
        assertEquals(collection.size(), list.getSize());
        assertEquals(collection.get(0), list.getFirst());
        assertEquals(collection.get(5), list.getLast());
    }

    @Test
    public void testAddFirstItem() {

        // given
        Integer value = anyInt();

        // then
        list.addFirst(value);

        // then
        assertEquals(1, list.getSize());
        assertEquals(value, list.getFirst());
        assertEquals(value, list.getLast());
    }

    @Test
    public void testAddFirstNullItem() {

        // then
        list.addFirst(nullValue());

        // then
        assertEquals(1, list.getSize());
        assertEquals(null, list.getFirst());
        assertEquals(null, list.getLast());
    }

    @Test
    public void testAddFirstList() {

        // given
        LinkList<Integer> newList = new LinkList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        list.addFirst(0);
        list.addFirst(newList);

        // then
        assertEquals(7, list.getSize());
        assertEquals(new Integer(6), list.getFirst());
        assertEquals(new Integer(0), list.getLast());
    }

    @Test
    public void testAddLastItem() {

        // given
        Integer value = anyInt();

        // then
        list.addLast(value);

        // then
        assertEquals(1, list.getSize());
        assertEquals(value, list.getFirst());
        assertEquals(value, list.getLast());
    }

    @Test
    public void testAddLastList() {

        // given
        LinkList<Integer> newList = new LinkList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        list.addLast(0);
        list.addLast(newList);

        // then
        assertEquals(7, list.getSize());
        assertEquals(new Integer(0), list.getFirst());
        assertEquals(new Integer(6), list.getLast());
    }

    @Test
    public void testAddLastAndLastItem() {

        // given
        Integer first = anyInt();
        Integer last = anyInt();

        // then
        list.addFirst(first);
        list.addLast(last);

        // then
        assertEquals(2, list.getSize());
        assertEquals(first, list.getFirst());
        assertEquals(last, list.getLast());
    }

    @Test
    public void testAddLastAndLastList() {

        // given
        LinkList<Integer> first = new LinkList<>(Arrays.asList(4, 3, 2, 1));
        LinkList<Integer> last = new LinkList<>(Arrays.asList(5, 6, 7));

        // then
        list.addFirst(first);
        list.addLast(last);

        // then
        assertEquals(7, list.getSize());
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(new Integer(7), list.getLast());
    }

    @Test
    public void testRemoveFirstElement() {

        // given
        list.addLast(100);
        list.addLast(200);

        // when
        list.removeFirst();

        // then
        assertEquals(1, list.getSize());
        assertEquals(new Integer(200), list.getFirst());
        assertEquals(new Integer(200), list.getLast());
    }

    @Test
    public void testRemoveLastElement() {

        // given
        list.addLast(100);
        list.addLast(200);

        // when
        list.removeLast();

        // then
        assertEquals(1, list.getSize());
        assertEquals(new Integer(100), list.getFirst());
        assertEquals(new Integer(100), list.getLast());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstFromEmptyList() {

        // when
        list.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastFromEmptyList() {

        // when
        list.removeLast();
    }

    @Test
    public void testRemoveIndexedEntry() {

        // given
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // when
        list.remove(0);

        // then
        assertEquals(2, list.getSize());
        assertEquals(new Integer(2), list.getFirst());
        assertEquals(new Integer(3), list.getLast());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveInvalidIndexedEntry() {

        // given
        list.addLast(1);
        list.addLast(2);

        // when
        list.remove(12);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveIndexedFromEmptyList() {

        // when
        list.remove(0);
    }

    @Test
    public void testIterateOverList() {

        // given
        List<Integer> result = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        // when
        for(Integer value : list) {
            result.add(value);
        }

        // then
        assertEquals(list.getSize(), result.size());
        assertEquals(list.getFirst(), result.get(0));
        assertEquals(list.getLast(), result.get(2));
    }

    @Test
    public void testIterateOverEmptyList() {

        // given
        List<Integer> result = new LinkedList<>();

        // when
        for(Integer value : list) {
            result.add(value);
        }

        // then
        assertTrue(list.isEmpty());
        assertEquals(list.getSize(), result.size());
    }

    @Test
    public void testArrayContainsValue() {

        // given
        list = new LinkList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        boolean result = list.contains(5);

        // then
        assertTrue(result);

    }

    @Test
    public void testArrayNotContainsValue() {

        // given
        list = new LinkList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        boolean result = list.contains(555);

        // then
        assertFalse(result);
    }

    @Test
    public void testArrayContainsNullValue() {

        // given
        list = new LinkList<>(Arrays.asList(1, 2, null, 4, 5, 6));

        // when
        boolean result = list.contains(null);

        // then
        assertTrue(result);
    }

    @Test
    public void testIndexOfElement() {

        // given
        list = new LinkList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        int result = list.indexOf(5);

        // then
        assertFalse(list.isEmpty());
        assertEquals(4, result);
    }

    @Test
    public void testIndexOfNullElement() {

        // given
        list = new LinkList<>(Arrays.asList(1, 2, 3, null, 5, 6));

        // when
        int result = list.indexOf(null);

        // then
        assertFalse(list.isEmpty());
        assertEquals(3, result);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIndexOfInvalidElement() {

        // given
        list = new LinkList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        list.indexOf(555);
    }

    @Test
    public void testReversLinkList() {

        // given
        list = new LinkList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        list.revers();

        // then
        assertNotNull(list);
        assertEquals(new Integer(6), list.getFirst());
        assertEquals(new Integer(1), list.getLast());
    }

    @Test
    public void testReversSingleElementList() {

        // given
        list.addLast(111);

        // when
        list.revers();

        // then
        assertEquals(new Integer(111), list.getFirst());
        assertEquals(new Integer(111), list.getLast());
    }

    @Test
    public void testReversEmptyList() {

        // when
        list.revers();

        // then
        assertTrue(list.isEmpty());
    }

    private Integer nullValue() {
        return null;
    }
}
