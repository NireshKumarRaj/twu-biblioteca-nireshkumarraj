package com.twu.biblioteca;

import java.util.Scanner;

public class Input {

    private Library library;
    private Menu menu;
    private final int VIEW_BOOKS_CHOICE = 1;
    private final int CHECKOUT_BOOKS_CHOICE = 2;
    private final int RETURN_BOOKS_CHOICE = 3;

    public Input(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;
    }

    public void get() {
        Scanner scanner = new Scanner(System.in);
        int inputFromUser = getMenuOption(scanner);
        while (!menu.isQuit(inputFromUser)) {
            if (inputFromUser == VIEW_BOOKS_CHOICE) {
                library.view();
            } else {
                if (inputFromUser == CHECKOUT_BOOKS_CHOICE) {
                    String bookName = getBookName(scanner, "Enter Book Name: ");
                    library.checkout(bookName.trim());
                } else {
                    if (inputFromUser == RETURN_BOOKS_CHOICE) {
                        String bookName = getBookName(scanner, "Enter name of the book you want to return: ");
                        library.returnBook(bookName);
                    } else {
                        System.out.println("Please select a valid option!");
                    }
                }
            }
            inputFromUser = getMenuOption(scanner);
        }
        scanner.close();
    }

    private String getBookName(Scanner scanner, String message) {
        System.out.println(message);
        scanner.nextLine();
        return scanner.nextLine();
    }

    private int getMenuOption(Scanner scanner) {
        System.out.println("Enter input: ");
        return scanner.nextInt();
    }
}
