package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Book> checkOutList;

    Library(List<Book> books) {
        this.books = books;
        this.checkOutList = new ArrayList<>();
    }

    private Book getBook(List<Book> bookList, String bookName) {
        Book toFindBook = new Book(bookName);
        for (Book book : bookList) {
            if (toFindBook.equals(book)) {
                return book;
            }
        }
        return null;
    }

    public void view() {
        this.books.forEach(book -> {
            if (!this.checkOutList.contains(book)) {
                book.viewInfo();
            }
        });
    }

    public void checkout(String bookName) {
        final String BOOK_NOT_AVAILABLE_MESSAGE = "Sorry, that book is not available";
        final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy the book";
        Book book = getBook(books, bookName);
        if (book == null) {
            System.out.println(BOOK_NOT_AVAILABLE_MESSAGE);
        } else {
            checkOutList.add(book);
            System.out.println(CHECKOUT_SUCCESS_MESSAGE);
        }
    }

    public void returnBook(String bookName) {
        String BOOK_INVALID_MESSAGE = "That is not a valid book to return.";
        String BOOK_RETURN_SUCCESS_MESSAGE = "Thank you for returning the book";
        Book book = getBook(checkOutList, bookName);
        if (book == null) {
            System.out.println(BOOK_INVALID_MESSAGE);
        } else {
            checkOutList.remove(book);
            System.out.println(BOOK_RETURN_SUCCESS_MESSAGE);
        }
    }
}
