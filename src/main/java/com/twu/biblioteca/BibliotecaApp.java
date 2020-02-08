package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private Library library;


    public BibliotecaApp() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = Arrays.asList(book1, book2, book3);
        library = new Library(books);
    }

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        displayWelcomeMessage();

        Menu menu = new Menu(List.of("List Books", "Checkout", "Return Book", "Quit"));
        menu.display();

        Input input = new Input(library, menu);
        input.get();
    }

    public void displayWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
}
