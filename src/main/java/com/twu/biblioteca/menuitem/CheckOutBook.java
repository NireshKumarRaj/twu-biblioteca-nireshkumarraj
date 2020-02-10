package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;

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
        Scanner scanner = new Scanner(System.in);
        library.checkout(scanner.nextLine());
        scanner.close();
    }

    @Override
    public String getName() {
        return name;
    }
}
