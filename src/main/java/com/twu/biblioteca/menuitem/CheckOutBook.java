package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;

public class CheckOutBook implements MenuItem{

    private Library library;
    private final String name;

    public CheckOutBook(Library library) {
        name = "Checkout";
        this.library = library;
    }

    @Override
    public void execute() {
        library.checkout("Pragmatic Programmer");
    }

    @Override
    public String getName() {
        return name;
    }
}
