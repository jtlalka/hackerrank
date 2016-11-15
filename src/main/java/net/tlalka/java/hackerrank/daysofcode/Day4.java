package net.tlalka.java.hackerrank.daysofcode;

import java.util.Scanner;

public class Day4 {

    private static class Person {

        private int age = 0;

        public Person(int age) {
            if (age < 0) {
                logger("Age is not valid, setting age to 0.");
            } else {
                this.age = age;
            }
        }

        public void amIOld() {
            if (age < 13) {
                logger("You are young.");
            } else if (age < 18) {
                logger("You are a teenager.");
            } else {
                logger("You are old.");
            }
        }

        public void yearPasses() {
            this.age++;
        }

        private void logger(String message) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int age = scanner.nextInt();
            Person person = new Person(age);
            person.amIOld();

            for (int j = 0; j < 3; j++) {
                person.yearPasses();
            }
            person.amIOld();
            System.out.println();
        }
        scanner.close();
    }
}
