package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.controller.InputReceiver;
import com.twu.biblioteca.model.Library;

public class BookCheckOut implements MenuItem, Auth {

    private Library library;
    private final String name;

    public BookCheckOut(Library library) {
        name = "Checkout Book";
        this.library = library;
    }

    @Override
    public void execute() {
        library.notifyListener("Enter Book Name: ");
        String bookName = InputReceiver.getInputReceiver().readLine();
        library.checkout(bookName);
    }

    @Override
    public String getName() {
        return name;
    }
}
