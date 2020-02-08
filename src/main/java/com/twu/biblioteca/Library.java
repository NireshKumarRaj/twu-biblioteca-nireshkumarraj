package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Book> checkOutList;

    Library(List<Book> books){
        this.books = books;
        this.checkOutList = new ArrayList<>();
    }

    public void view() {
        this.books.forEach(book -> {
            if (!this.checkOutList.contains(book)){
                book.viewInfo();
            }
        });
    }


    public void checkout(String bookName) {
        Book toFindBook = new Book(bookName);
        boolean isFound = false;
        for (Book book: books){
            if (toFindBook.equals(book)){
                checkOutList.add(book);
                System.out.println("Thank you! Enjoy the book");
                isFound = true;
                break;
            }
        }
        if (!isFound)System.out.println("Sorry, that book is not available");
    }

    public void returnBook(String bookName) {
        boolean isFound = false;
        Book toFindBook = new Book(bookName);
        for (Book book: checkOutList){
            if (toFindBook.equals(book)){
                checkOutList.remove(book);
                System.out.println("Thank you for returning the book");
                isFound = true;
                break;
            }
        }
        if (!isFound) System.out.println("That is not a valid book to return.");
    }
}
