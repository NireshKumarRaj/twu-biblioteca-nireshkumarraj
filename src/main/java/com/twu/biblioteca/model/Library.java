package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    // TODO - what can be an alternate implementation of this Libarary? Think about it and get back. Try to see if that's better - simplifies, complicates the implementation
    private List<Book> books;
    private List<Book> checkedOutBooks;

    public Library(List<Book> books) { // TODO - I do like you parameterized this
        this.books = books;
        this.checkedOutBooks = new ArrayList<>();
    }

    private Book getBook(List<Book> bookList, String bookName) { // TODO - Optional from Java. - low priority
        for (Book book : bookList) { // TODO - could you not use a lambda here? Try that.
            if (book.is(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void view() {
        System.out.println();
        this.books.stream()
                .filter(book -> !this.checkedOutBooks.contains(book))
                .collect(Collectors.toList()).forEach(Book::viewInfo);
        System.out.println();
    }

    public void checkout(String bookName) {
        final String BOOK_NOT_AVAILABLE_MESSAGE = "Sorry, that book is not available";
        final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the book";
        Book book = getBook(books, bookName);
        if (book == null) { // TODO - see if you can get rid of the if-else. Can we be polymorphic, over what? - low priority
            System.out.println(BOOK_NOT_AVAILABLE_MESSAGE);
        } else {
            checkedOutBooks.add(book);
            System.out.println(CHECKOUT_SUCCESS_MESSAGE);
        }
    }

    public void returnBook(String bookName) {
        String BOOK_INVALID_MESSAGE = "That is not a valid book to return.";
        String BOOK_RETURN_SUCCESS_MESSAGE = "Thank you for returning the book";
        Book book = getBook(checkedOutBooks, bookName);
        if (book == null) {
            System.out.println(BOOK_INVALID_MESSAGE);
        } else {
            checkedOutBooks.remove(book);
            System.out.println(BOOK_RETURN_SUCCESS_MESSAGE);
        }
    }
}
