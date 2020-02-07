package com.twu.biblioteca;

import java.util.List;

public class Library {

    private List<Book> books;

    Library(List<Book> books){
        this.books = books;
    }

    public void view() {
        this.books.forEach(Book::viewInfo);
    }
}
