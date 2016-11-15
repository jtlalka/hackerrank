package net.tlalka.java.hackerrank.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTablesNote {

    public static boolean isInputContainsText(String[] input, String[] text) {
        List<String> inputList = new ArrayList<>(Arrays.asList(input));
        return Arrays.stream(text).allMatch(inputList::remove);
    }
}
