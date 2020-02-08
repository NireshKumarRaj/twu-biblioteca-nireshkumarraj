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
        System.out.println("Enter input: ");
        Scanner scanner = new Scanner(System.in);
        int inputFromUser = scanner.nextInt();

        if(menu.isQuit(inputFromUser)){
            return;
        }

        if (inputFromUser == 1) {
            library.view();
        } else {
            System.out.println("Please select a valid option!");
        }
        scanner.close();
    }
}
