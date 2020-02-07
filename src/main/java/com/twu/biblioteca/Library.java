package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> books;

    Library(){
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        books = Arrays.asList(book1, book2, book3);
    }

    public void view() {
        this.books.forEach(Book::viewInfo);
    }
}
