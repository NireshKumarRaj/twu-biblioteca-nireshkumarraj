package com.twu.biblioteca.data;

import com.twu.biblioteca.menuitem.*;
import com.twu.biblioteca.model.*;

import java.util.List;

import static java.util.List.of;

public class DummyDataGenerator {

    private final Menu menu;
    private final MovieLibrary movieLibrary;
    private final Authenticator authenticator;
    private final Library library;

    public DummyDataGenerator() {
        library = new Library(getBooks());
        movieLibrary = new MovieLibrary(getMovies());
        authenticator = new Authenticator(getUsers());
        menu = new Menu(getMenuItems(library, movieLibrary, authenticator));
    }

    public Menu getMenu() {
        return menu;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public Library getLibrary() {
        return library;
    }

    public MovieLibrary getMovieLibrary() {
        return movieLibrary;
    }

    private List<Book> getBooks() {
        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        return of(book1, book2, book3);
    }

    private List<Movie> getMovies() {
        Movie movie1 = new Movie("The Social Network", 2010, "Mark", 8);
        Movie movie2 = new Movie("Apple", 2011, "Steve", 9);
        Movie movie3 = new Movie("Theory of Everything", 2000, "Fleming", 8);
        return of(movie1, movie2, movie3);
    }

    private List<User> getUsers() {
        User user1 = new User("name", "email", "+919941980802", "123-4567", "test1");
        User user2 = new User("name", "email", "+919941980802", "123-4568", "test1");
        User user3 = new User("name", "email", "+919941980802", "123-4569", "test1");

        return of(user1, user2, user3);
    }

    private List<MenuItem> getMenuItems(Library library, MovieLibrary movieLibrary, Authenticator authenticator) {
        BookList bookListMenuItem = new BookList(library);
        BookCheckOut bookCheckOutMenuItem = new BookCheckOut(library);
        MovieCheckOut movieCheckOutMenuItem = new MovieCheckOut(movieLibrary);
        BookReturn bookReturnMenuItem = new BookReturn(library);
        MovieList movieListMenuItem = new MovieList(movieLibrary);
        LoginMenuItem loginMenuItem = new LoginMenuItem(authenticator);
        ViewUser viewUserMenuItem = new ViewUser();
        CheckedOutBooks checkedOutBooksMenuItem = new CheckedOutBooks(library);
        Quit quitMenuItem = new Quit();
        return of(
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
    }
}
