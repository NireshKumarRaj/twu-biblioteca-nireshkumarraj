package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Model;

import java.io.PrintStream;
import java.util.List;

public class UI implements View {

    private final PrintStream outputWriter;

    public UI(PrintStream outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void addModel(Model model) {
        model.setListener(this);
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
        System.out.println();
    }
}
