package net.tlalka.java.hackerrank.daysofcode;

import java.util.Arrays;

public class Day12 {

    private static class Person {
        protected String firstName;
        protected String lastName;
        protected int idNumber;

        public Person(String firstName, String lastName, int identification) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = identification;
        }

        public void printPerson() {
            System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
        }
    }

    enum GradeType {
        O('O', 90, 100),
        E('E', 80, 89),
        A('A', 70, 79),
        P('P', 55, 69),
        D('D', 40, 54),
        T('T', 0, 39);

        private char letter;
        private double min;
        private double max;

        GradeType(char letter, double min, double max) {
            this.letter = letter;
            this.min = min;
            this.max = max;
        }

        public static char getLetter(double note) {
            return Arrays.stream(values())
                    .filter(v -> note >= v.min && note <= v.max)
                    .map(v -> v.letter)
                    .findFirst()
                    .orElse('X');
        }
    }

    private static class Student extends Person {
        private int[] testScores;

        public Student(String firstName, String lastName, int identification, int[] testScores) {
            super(firstName, lastName, identification);
            this.testScores = testScores;
        }

        public char calculate() {
            return GradeType.getLetter(Arrays.stream(testScores).average().orElse(0));
        }
    }

    public static void main(String[] args) {
        Student student = new Student("John", "Doo", 771, new int[] {100, 80});
        student.printPerson();
        System.out.println("Grade: " + student.calculate());
    }
}
