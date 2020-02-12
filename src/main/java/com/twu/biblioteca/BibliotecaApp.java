package com.twu.biblioteca;

import com.twu.biblioteca.menuitem.*;
import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.BibliotecaController;
import com.twu.biblioteca.view.UI;

import java.util.List;

import static java.util.List.of;

public class BibliotecaApp {

    private Library library;
    private Menu menu;
    private MovieLibrary movieLibrary;
    private Authenticator authenticator;

    public BibliotecaApp() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = of(book1, book2, book3);
        library = new Library(books);

        Movie movie1 = new Movie("The Social Network", 2010, "Mark", 8);
        Movie movie2 = new Movie("Apple", 2011, "Steve", 9);
        Movie movie3 = new Movie("Theory of Everything", 2000, "Fleming", 8);
        List<Movie> movies = of(movie1, movie2, movie3);
        movieLibrary = new MovieLibrary(movies);

        User user1 = new User("name", "email", "+919941980802", "123-4567", "test1");
        User user2 = new User("name", "email", "+919941980802", "123-4568", "test1");
        User user3 = new User("name", "email", "+919941980802", "123-4569", "test1");
        authenticator = new Authenticator(of(user1, user2, user3));

        BookList bookListMenuItem = new BookList(library);
        BookCheckOut bookCheckOutMenuItem = new BookCheckOut(library);
        MovieCheckOut movieCheckOutMenuItem = new MovieCheckOut(movieLibrary);
        BookReturn bookReturnMenuItem = new BookReturn(library);
        MovieList movieListMenuItem = new MovieList(movieLibrary);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);
        ViewUser viewUserMenuItem = new ViewUser();
        CheckedOutBooks checkedOutBooksMenuItem = new CheckedOutBooks(library);
        Quit quitMenuItem = new Quit();
        List<MenuItem> menuItems = of(
                bookListMenuItem,
                bookCheckOutMenuItem,
                checkedOutBooksMenuItem,
                bookReturnMenuItem,
                movieListMenuItem,
                movieCheckOutMenuItem,
                loginMenuItem,
                viewUserMenuItem,
                quitMenuItem
        );
        menu = new Menu(menuItems);
    }

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        UI ui = new UI(System.out);
        ui.addModel(menu);
        ui.addModel(library);
        ui.addModel(movieLibrary);
        ui.addModel(authenticator);
        BibliotecaController bibliotecaController = new BibliotecaController(menu, ui);
        bibliotecaController.start();
    }
}
