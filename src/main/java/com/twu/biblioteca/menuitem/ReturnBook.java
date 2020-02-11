package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.InputReceiver;

public class ReturnBook implements MenuItem {

    private final String name;
    private Library library;

    public ReturnBook(Library library) {
        this.library = library;
        name = "Return Book";
    }

    @Override
    public void execute() {
        System.out.println("Enter name of the book you want to return: ");
        String bookName = InputReceiver.getInputReceiver().readLine();
        library.returnBook(bookName);
    }

    @Override
    public String getName() {
        return name;
    }
}
