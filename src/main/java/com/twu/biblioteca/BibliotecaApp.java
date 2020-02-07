package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        displayWelcomeMessage();

        Library library = new Library();
        library.view();
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
