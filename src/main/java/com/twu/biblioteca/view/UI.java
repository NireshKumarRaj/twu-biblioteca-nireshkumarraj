package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;

import java.util.List;

public class UI implements Customer {

    public UI(Menu menu, Library library) {
        library.setListener(this);
        menu.setListener(this);
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void display(List<String> toDisplayList) {
        for (int itemNumber = 1; itemNumber <= toDisplayList.size(); itemNumber++) {
            final String SEPARATOR = ". ";
            System.out.println((itemNumber) + SEPARATOR + toDisplayList.get(itemNumber - 1));
        }
    }
}
