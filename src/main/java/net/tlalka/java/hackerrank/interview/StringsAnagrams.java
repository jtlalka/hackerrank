package net.tlalka.java.hackerrank.interview;

import java.util.Arrays;

public class StringsAnagrams {

    public static int numberNeeded(String first, String second) {
        int[] freq = new int[26];
        int firstChar = 'a';

        first.chars().forEach(l -> freq[l - firstChar]++);
        second.chars().forEach(l -> freq[l - firstChar]--);

        return Arrays.stream(freq).map(Math::abs).sum();
    }
}
