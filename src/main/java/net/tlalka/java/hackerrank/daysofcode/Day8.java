package net.tlalka.java.hackerrank.daysofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {

    private static Map<String, Integer> phones = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                phones.put(scanner.next(), scanner.nextInt());
            }

            while (scanner.hasNext()) {
                String name = scanner.next();
                if (phones.containsKey(name)) {
                    System.out.println(name + "=" + phones.get(name));
                } else {
                    System.out.println("Not found");
                }
            }
        }
    }
}
