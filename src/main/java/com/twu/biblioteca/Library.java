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

    public void view() {
        this.books.forEach(book -> {
            if (!this.checkOutList.contains(book)) {
                book.viewInfo();
            }
        });
    }

    public void checkout(String bookName) {
        Book book = getBook(books, bookName);
        if (book == null) {
            System.out.println("Sorry, that book is not available");
        } else {
            checkOutList.add(book);
            System.out.println("Thank you! Enjoy the book");
        }
    }

    public void returnBook(String bookName) {
        Book book = getBook(checkOutList, bookName);
        if (book == null) {
            System.out.println("That is not a valid book to return.");
        } else {
            checkOutList.remove(book);
            System.out.println("Thank you for returning the book");
        }
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
}
