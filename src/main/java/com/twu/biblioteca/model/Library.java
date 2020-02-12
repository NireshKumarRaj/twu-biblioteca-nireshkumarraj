package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library implements Model {

    // TODO - what can be an alternate implementation of this Libarary? Think about it and get back. Try to see if that's better - simplifies, complicates the implementation
    private List<Book> books;
    private Map<Book, String> checkedOutBooks;
    private View view;

    public Library(List<Book> books) {
        this.books = books;
        this.checkedOutBooks = new HashMap<>();
    }

    private Optional<Book> getBook(Stream<Book> bookList, String bookName) {
        return bookList.filter(book -> book.is(bookName)).findFirst();
    }

    public void listAvailableBooks() {
        this.view.display(this.books.stream()
                .filter(book -> !this.checkedOutBooks.containsKey(book))
                .map(Book::getDetails)
                .collect(Collectors.toList()));
    }

    public void checkout(String bookName) {
        final String BOOK_NOT_AVAILABLE_MESSAGE = "Sorry, that book is not available";
        final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the book";
        Optional<Book> book = getBook(books.stream(), bookName).filter(item -> !checkedOutBooks.containsKey(item));
        if (book.isPresent()) { // TODO - see if you can get rid of the if-else. Can we be polymorphic, over what? - low priority
            checkedOutBooks.put(book.get(), view.getLoggedInUser());
            notifyListener(CHECKOUT_SUCCESS_MESSAGE);
        } else {
            notifyListener(BOOK_NOT_AVAILABLE_MESSAGE);
        }
    }

    public void returnBook(String bookName) {
        String BOOK_INVALID_MESSAGE = "That is not a valid book to return.";
        String BOOK_RETURN_SUCCESS_MESSAGE = "Thank you for returning the book";
        Optional<Book> book = getBook(checkedOutBooks.keySet().stream(), bookName);
        if (book.isPresent()) {
            checkedOutBooks.remove(book.get());
            notifyListener(BOOK_RETURN_SUCCESS_MESSAGE);
        } else {
            notifyListener(BOOK_INVALID_MESSAGE);
        }
    }

    public void setListener(View view) {
        this.view = view;
    }

    public void notifyListener(String message) {
        this.view.display(message);
    }
}
