package com.twu.biblioteca;

import com.twu.biblioteca.menuitem.BookCheckOut;
import com.twu.biblioteca.menuitem.BookList;
import com.twu.biblioteca.menuitem.BookReturn;
import com.twu.biblioteca.menuitem.Quit;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.view.BibliotecaController;
import com.twu.biblioteca.view.UI;

import java.util.List;

import static java.util.List.of;

public class BibliotecaApp {

    private Library library;
    private Menu menu;

    public BibliotecaApp() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = of(book1, book2, book3);
        library = new Library(books);

        BookList bookListMenuItem = new BookList(library);
        BookCheckOut bookCheckOutMenuItem = new BookCheckOut(library);
        BookReturn bookReturnMenuItem = new BookReturn(library);
        Quit quitMenuItem = new Quit();
        menu = new Menu(of(bookListMenuItem, bookCheckOutMenuItem, bookReturnMenuItem, quitMenuItem));
    }

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        UI ui = new UI(menu, library, System.out);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);
        bibliotecaController.start();
    }


}
