package net.tlalka.java.hackerrank.interview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class ArraysLeftRotationTest {

    @Test
    public void testRotateArrayByVector() {

        // given
        Integer[] test = {1, 2, 3, 4, 5};
        int vector = 2;

        // when
        Integer[] result = ArraysLeftRotation.leftRotate(test, vector);

        // then
        Integer[] expected = {3, 4, 5, 1, 2};

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRotateArrayNullVector() {

        // given
        Integer[] test = {1, 2, 3, 4, 5};
        int vector = 0;

        // when
        Integer[] result = ArraysLeftRotation.leftRotate(test, vector);

        // then
        assertNotNull(result);
        assertArrayEquals(test, result);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRotateArrayByInvalidVector() {

        // given
        Integer[] test = {1, 2, 3, 4, 5};
        int vector = 100;

        // when
        ArraysLeftRotation.leftRotate(test, vector);
    }
}
