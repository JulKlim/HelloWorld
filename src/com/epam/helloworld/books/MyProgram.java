package com.epam.helloworld.books;

import java.util.Arrays;
import java.util.Comparator;
public class MyProgram {
    public static void main(String[] args) {
        Author Author1 = new Author(54,"George", "Orwell");
        Author Author2 = new Author(657, "Jane","Austen");
        Author Author3 = new Author(78, "Suzanne","Collins");
        Author Author4 = new Author(68, "Arthur", "Conan Doyle");
        Author Author5 = new Author(975,"Harper", "Lee");


        Publisher Publisher1 = new Publisher(435, "HarperCollins", "195 Broadway, New York, NY 10007, United States");
        Publisher Publisher2 = new Publisher(635, "Egerton", "1 Whitehall St, Westminster, London SW1A 2HH, UK");
        Publisher Publisher3 = new Publisher(876, "Scholastic Press", "557 Broadway, New York, NY 10012");
        Publisher Publisher4 = new Publisher(146, "George Newnes Ltd", "Tower House, Southampton St, London WC2E 7HA, UK");
        Publisher Publisher5 = new Publisher(629, "Secker & Warburg", "6-7 St Martin's Pl, London WC2H 0QA, UK");


        Book Book1 = new Book(73836280, "1984", Author1, Publisher1, "15:10:2014", true);
        Book Book2 = new Book(65467784, "Pride and Prejudice", Author2, Publisher2, "10:04:2004", false);
        Book Book3 = new Book(74676252, "The Hunger Games", Author3, Publisher3, "05:11:2016", false);
        Book Book4 = new Book(85445572, "The Adventures of Sherlock Holmes", Author4, Publisher4, "19:05:1995", true);
        Book Book5 = new Book(11144477, "To Kill a Mockingbird", Author5, Publisher5, "01:02:1956", true);

        Book[] books = {Book1, Book2, Book3, Book4, Book5};
        Arrays.sort(books, Comparator.comparing(Book::getISBN));
        for (Book book: books) {
            System.out.println(book);
        }

    }
}
