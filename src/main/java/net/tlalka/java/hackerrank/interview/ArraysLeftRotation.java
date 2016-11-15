package net.tlalka.java.hackerrank.interview;

public class ArraysLeftRotation {

    public static <E> E[] leftRotate(E[] array, int vector) {
        E[] rotated = array.clone();
        int length = array.length;

        System.arraycopy(array, vector, rotated, 0, length - vector);
        System.arraycopy(array, 0, rotated, length - vector, vector);
        return rotated;
    }
}
