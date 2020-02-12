package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.controller.InputReceiver;
import com.twu.biblioteca.model.Library;

public class BookReturn implements MenuItem, Auth {

    private final String name;
    private Library library;

    public BookReturn(Library library) {
        this.library = library;
        name = "Return Book";
    }

    @Override
    public void execute() {
        library.notifyListener("Enter name of the book you want to return: ");
        String bookName = InputReceiver.getInputReceiver().readLine();
        library.returnBook(bookName);
    }

    @Override
    public String getName() {
        return name;
    }
}
