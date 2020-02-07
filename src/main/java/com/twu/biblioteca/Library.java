package com.twu.biblioteca;

import java.util.Collections;
import java.util.List;

public class Library {

    private List<String> books;

    Library(){
        books = Collections.singletonList("Pragmatic Programmer");
    }

    public void view() {
        this.books.forEach(System.out::println);
    }
}
