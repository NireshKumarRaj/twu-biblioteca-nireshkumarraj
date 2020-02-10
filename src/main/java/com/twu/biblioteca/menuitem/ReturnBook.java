package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;

public class ReturnBook implements MenuItem {

    private final String name;
    private Library library;

    public ReturnBook(Library library) {
        this.library = library;
        name = "Return Book";
    }

    @Override
    public void execute() {
        library.returnBook("Agile");
    }

    @Override
    public String getName() {
        return name;
    }
}
