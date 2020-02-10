package com.twu.biblioteca;

import com.twu.biblioteca.menuitem.CheckOutBook;
import com.twu.biblioteca.menuitem.ListBooks;
import com.twu.biblioteca.menuitem.Quit;
import com.twu.biblioteca.menuitem.ReturnBook;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.view.BibliotecaController;

import java.util.List;

public class BibliotecaApp {

    private Library library;
    private Menu menu;

    public BibliotecaApp() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = List.of(book1, book2, book3);
        library = new Library(books);

        ListBooks listBooksMenuItem = new ListBooks(library);
        CheckOutBook checkOutBookMenuItem = new CheckOutBook(library);
        ReturnBook returnBookMenuItem = new ReturnBook(library);
        Quit quitMenuItem = new Quit();
        menu = Menu.createMenuWithMenuItems(List.of(listBooksMenuItem,checkOutBookMenuItem, returnBookMenuItem, quitMenuItem));
    }

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        displayWelcomeMessage();

        BibliotecaController bibliotecaController = new BibliotecaController(library, menu);
        bibliotecaController.start();
    }

    public void displayWelcomeMessage() {
        String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        System.out.println(WELCOME_MESSAGE);
    }
}
