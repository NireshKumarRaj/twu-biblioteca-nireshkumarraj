package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {

    // TODO - what can be an alternate implementation of this Libarary? Think about it and get back. Try to see if that's better - simplifies, complicates the implementation
    private List<Book> books;
    private List<Book> checkedOutBooks;

    public Library(List<Book> books) {
        this.books = books;
        this.checkedOutBooks = new ArrayList<>();
    }

    private Optional<Book> getBook(List<Book> bookList, String bookName) {
        return bookList.stream().filter(book -> book.is(bookName)).findFirst();
    }

    public List<String> getAvailableBooks() {
        System.out.println();
        List<String> availableBooks = this.books.stream()
                .filter(book -> !this.checkedOutBooks.contains(book))
                .map(Book::getDetails)
                .collect(Collectors.toList());
        System.out.println();
        return availableBooks;
    }

    public void checkout(String bookName) {
        final String BOOK_NOT_AVAILABLE_MESSAGE = "Sorry, that book is not available";
        final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the book";
        Optional<Book> book = getBook(books, bookName).filter(item -> !checkedOutBooks.contains(item));
        if (book.isPresent()) { // TODO - see if you can get rid of the if-else. Can we be polymorphic, over what? - low priority
            checkedOutBooks.add(book.get());
            System.out.println(CHECKOUT_SUCCESS_MESSAGE);
        } else {
            System.out.println(BOOK_NOT_AVAILABLE_MESSAGE);
        }
    }

    public void returnBook(String bookName) {
        String BOOK_INVALID_MESSAGE = "That is not a valid book to return.";
        String BOOK_RETURN_SUCCESS_MESSAGE = "Thank you for returning the book";
        Optional<Book> book = getBook(checkedOutBooks, bookName);
        if (book.isPresent()) {
            checkedOutBooks.remove(book.get());
            System.out.println(BOOK_RETURN_SUCCESS_MESSAGE);
        } else {
            System.out.println(BOOK_INVALID_MESSAGE);
        }
    }
}
