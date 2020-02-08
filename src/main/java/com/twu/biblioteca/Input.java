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
        System.out.println("Enter input: ");
        int inputFromUser = scanner.nextInt();
        while (!menu.isQuit(inputFromUser)) {
            if (inputFromUser == 1) {
                library.view();
            } else if (inputFromUser == 2) {
                System.out.println("Enter Book Name: ");
                scanner.nextLine();
                String bookName = scanner.nextLine();
            } else {
                System.out.println("Please select a valid option!");
            }
            System.out.println("Enter input: ");
            inputFromUser = scanner.nextInt();
        }

        scanner.close();
    }
}
