package com.twu.biblioteca;

import java.util.Scanner;

public class Input {

    private Library library;
    private Menu menu;

    public Input(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;
    }

    public void get() {
        Scanner scanner = new Scanner(System.in);
        int inputFromUser = getMenuOption(scanner);
        while (!menu.isQuit(inputFromUser)) {
            if (inputFromUser == 1) {
                library.view();
            } else if (inputFromUser == 2) {
                String bookName = getBookName(scanner, "Enter Book Name: ");
                library.checkout(bookName.trim());
            } else if (inputFromUser == 3) {
                String bookName = getBookName(scanner, "Enter name of the book you want to return: ");
                library.returnBook(bookName);
            } else {
                System.out.println("Please select a valid option!");
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
