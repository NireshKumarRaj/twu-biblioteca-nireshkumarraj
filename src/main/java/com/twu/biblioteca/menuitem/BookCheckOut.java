package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.InputReceiver;

public class BookCheckOut implements MenuItem {

    private Library library;
    private final String name;
    private Authenticator authenticator;

    public BookCheckOut(Library library, Authenticator authenticator) {
        this.authenticator = authenticator;
        name = "Checkout";
        this.library = library;
    }

    @Override
    public void execute() {
        authenticator.authenticate("123-4567", "test1");
        library.notifyListener("Enter Book Name: ");
        String bookName = InputReceiver.getInputReceiver().readLine();
        library.checkout(bookName);
    }

    @Override
    public String getName() {
        return name;
    }
}
