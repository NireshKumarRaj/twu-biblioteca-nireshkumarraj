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
        for (Book book: books){
            if (toFindBook.equals(book)){
                checkOutList.add(book);
                System.out.println("Thank you! Enjoy the book");
                break;
            }
        }
    }
}
