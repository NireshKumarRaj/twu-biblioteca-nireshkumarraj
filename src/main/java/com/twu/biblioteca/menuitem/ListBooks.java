package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;

public class ListBooks implements MenuItem {

    private Library library;
    private final String name;

    public ListBooks(Library library) {
        this.library = library;
        name = "List Books";
    }

    @Override
    public void execute() {
        library.view();
    }

    @Override
    public String getName() {
        return name;
    }
}
