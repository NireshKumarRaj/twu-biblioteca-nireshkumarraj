package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;

import java.io.PrintStream;
import java.util.List;

public class UI implements Customer {

    private final PrintStream outputWriter;

    public UI(Menu menu, Library library, PrintStream outputWriter) {
        this.outputWriter = outputWriter;
        library.setListener(this);
        menu.setListener(this);
    }

    @Override
    public void display(String message) {
        outputWriter.println(message);
    }

    @Override
    public void display(List<String> toDisplayList) {
        for (int itemNumber = 1; itemNumber <= toDisplayList.size(); itemNumber++) {
            final String SEPARATOR = ". ";
            outputWriter.println((itemNumber) + SEPARATOR + toDisplayList.get(itemNumber - 1));
        }
    }
}
