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
        scanner.nextInt();
        scanner.close();

        library.view();
    }
}
