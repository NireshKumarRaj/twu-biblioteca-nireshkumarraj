package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Library {

    private List<String> books;

    Library(){
        books = Arrays.asList("Pragmatic Programmer", "Extreme Programming", "Agile Programming");
    }

    public void view() {
        this.books.forEach(System.out::println);
    }
}
