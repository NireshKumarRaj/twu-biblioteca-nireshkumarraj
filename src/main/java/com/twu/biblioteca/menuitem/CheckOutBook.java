package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.InputReceiver;

import java.util.Scanner;

public class CheckOutBook implements MenuItem{

    private Library library;
    private final String name;

    public CheckOutBook(Library library) {
        name = "Checkout";
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter Book Name: ");
        String bookName = InputReceiver.getInputReceiver().readLine();
        library.checkout(bookName);
    }

    @Override
    public String getName() {
        return name;
    }
}
