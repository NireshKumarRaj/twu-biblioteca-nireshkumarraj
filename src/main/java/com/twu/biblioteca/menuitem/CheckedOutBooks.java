package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;

public class CheckedOutBooks implements MenuItem, Auth {

    private final String name;
    private Library library;

    public CheckedOutBooks(Library library) {
        this.library = library;
        this.name = "List checked out books";
    }

    @Override
    public void execute() {
        library.listCheckOutBooks();
    }

    @Override
    public String getName() {
        return name;
    }
}
