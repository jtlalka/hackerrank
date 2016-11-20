package net.tlalka.java.hackerrank.daysofcode;

public class Day13 {

    static abstract class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        abstract void display();
    }

    static class MyBook extends Book {
        private int price;

        public MyBook(String title, String author, int price) {
            super(title, author);
            this.price = price;
        }

        @Override
        public void display() {
            System.out.format("Title: %s\nAuthor: %s\nPrice: %d", title, author, price);
        }
    }

    public static void main(String[] args) {
        Book myBook = new MyBook("The Witcher", "Andrzej Sapkowski", 112);
        myBook.display();
    }
}
