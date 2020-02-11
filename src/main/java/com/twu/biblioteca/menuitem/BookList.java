package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;

public class BookList implements MenuItem {

    private Library library;
    private final String name;

    public BookList(Library library) {
        this.library = library;
        name = "List Books";
    }

    @Override
    public void execute() {
        library.listAvailableBooks();
    }

    @Override
    public String getName() {
        return name;
    }
}
