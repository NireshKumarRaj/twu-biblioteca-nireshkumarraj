package com.twu.biblioteca;

import java.util.Scanner;

public class Input {

    private final int VIEW_BOOKS_CHOICE = 1;
    private final int CHECKOUT_BOOKS_CHOICE = 2;
    private final int RETURN_BOOKS_CHOICE = 3;
    private final String INVALID_OPTION_MESSAGE = "Please select a valid option!";

    private Library library;
    private Menu menu;
    private boolean isQuit = false;
    private Scanner scanner;

    public Input(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;
        scanner = new Scanner(System.in);
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

    public void get() {
        int inputFromUser = getMenuOption(scanner);
        if (menu.isQuit(inputFromUser)){
            this.isQuit = true;
            return;
        }
        switch (inputFromUser) {
            case VIEW_BOOKS_CHOICE:
                library.view();
                break;
            case CHECKOUT_BOOKS_CHOICE:
                String checkOutBookName = getBookName(scanner, "Enter Book Name: ");
                library.checkout(checkOutBookName.trim());
                break;
            case RETURN_BOOKS_CHOICE:
                String returnBookName = getBookName(scanner, "Enter name of the book you want to return: ");
                library.returnBook(returnBookName);
                break;
            default:
                System.out.println(INVALID_OPTION_MESSAGE);
        }
    }

    public void close(){
        scanner.close();
    }

    public boolean isQuit() {
        return isQuit;
    }
}
