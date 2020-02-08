package com.twu.biblioteca;

import java.util.Scanner;

public class Input {

    private Library library;

    public Input(Library library) {
        this.library = library;
    }

    public void get() {
        System.out.println("Enter input: ");
        Scanner scanner = new Scanner(System.in);
        int inputFromUser = scanner.nextInt();
        if (inputFromUser == 1) {
            library.view();
        } else {
            System.out.println("Please select a valid option!");
        }
        scanner.close();
    }
}
