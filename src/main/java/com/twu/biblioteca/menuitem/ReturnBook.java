package com.twu.biblioteca.menuitem;

import com.twu.biblioteca.model.Library;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        library.returnBook(scanner.nextLine());
        scanner.close();
    }

    @Override
    public String getName() {
        return name;
    }
}
