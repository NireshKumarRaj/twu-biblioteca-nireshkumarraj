package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InputTest {

    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private Library library;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Book book1 = new Book("Pragmatic Programmer", "Andy Hunt", 1998);
        Book book2 = new Book("Extreme Programming", "Kent Beck", 1998);
        Book book3 = new Book("Agile", "Andy", 1998);
        List<Book> books = Arrays.asList(book1, book2, book3);
        library = new Library(books);
    }

    @AfterEach
    void afterEach() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void checkIfUserInputIsReceived() {
        String data = "1\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, new Menu(List.of("List Books", "Quit")));
        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";
        String expected = out1 + "\n" + out2 + "\n" + out3;

        input.get();

        String dataFromOut = outContent.toString().replaceAll("1. List Books\n2. Quit","").trim().replace("Enter input:", "").trim();

        assertEquals(expected, dataFromOut);
    }

    @Test
    void checkIfUserEntersInvalidOption() {
        String data = "6\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, new Menu(List.of("List Books", "Quit")));

        input.get();

        String dataFromOut = outContent.toString().replaceAll("1. List Books\n2. Quit","").trim().replace("Enter input:", "").trim();
        String expected = "Please select a valid option!";
        assertEquals(expected, dataFromOut);
    }

    @Test
    void checkIfUserIsAbleToQuit() {
        String data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu(List.of("List Books", "Quit"));
        Input input = new Input(library, menu);

        input.get();

        String dataFromOut = outContent.toString().replaceAll("1. List Books\n2. Quit","").trim().replace("Enter input:", "").trim();
        assertEquals("", dataFromOut);
    }

    @Test
    void checkIfUserIsAbleToContinueUntilQuitIsChosen() {
        String data = "1\n1\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu(List.of("List Books", "Quit"));
        Input input = new Input(library, menu);
        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";
        String expected = out1 + "\n" + out2 + "\n" + out3;

        input.get();

        String dataFromOut = outContent.toString().replaceAll("1. List Books\n2. Quit\n","").trim().replaceAll("Enter input: \n","").trim().replaceAll("Enter input:","").trim();
        assertEquals((expected +  "\n" + expected), dataFromOut);
    }

    @Test
    void checkIfUserIsAbleToSelectCheckOutOptionAndProceed() {
        String data = "2\nPragmatic Programmer\n3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu(List.of("List Books", "Checkout", "Quit"));
        Input input = new Input(library, menu);

        input.get();

        String dataFromOut = outContent.toString().replaceAll("1. List Books\n2. Checkout\n3. Quit\n","").trim().replaceAll("Enter input:", "").replaceAll("Thank you! Enjoy the book", "").trim();
        assertEquals("Enter Book Name:", dataFromOut);
    }

    @Test
    void checkIfUserIsAbleToSelectCheckOutABook() {
        String data = "2\nPragmatic Programmer\n3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu(List.of("List Books", "Checkout", "Quit"));
        Input input = new Input(library, menu);
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";
        String expected = out2 + "\n" + out3;

        input.get();
        library.view();

        String dataFromOut = outContent.toString().replaceAll("1. List Books\n2. Checkout\n3. Quit","").trim().replaceAll("Enter Book Name:", "").trim().replaceAll("Enter input: ", "").replaceAll("Thank you! Enjoy the book", "").trim();
        assertEquals(expected, dataFromOut);
    }

    @Test
    void checkIfUserIsAbleToReturnABook() {
        String data = "3\nPragmatic Programmer\n4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu(List.of("List Books", "Checkout", "Return Book", "Quit"));
        Input input = new Input(library, menu);
        String out1 = "Pragmatic Programmer | Andy Hunt | 1998";
        String out2 = "Extreme Programming | Kent Beck | 1998";
        String out3 = "Agile | Andy | 1998";
        String expected = out1 + "\n" + out2 + "\n" + out3;

        library.checkout("Pragmatic Programmer");
        input.get();
        library.view();

        String dataFromOut = outContent.toString().replaceAll("1. List Books\n2. Checkout\n3. Return Book\n4. Quit","").trim()
                .replaceAll("Enter name of the book you want to return:", "").trim()
                .replaceAll("Enter input: ", "")
                .replaceAll("Thank you! Enjoy the book", "")
                .replaceAll("Thank you for returning the book", "").trim();
        assertEquals(expected, dataFromOut);
    }

    @Test
    void testIfIsQuitIsUpdatedUponSelectionOfOption() {
        String data = "4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu(List.of("List Books", "Checkout", "Return Book", "Quit"));
        Input input = new Input(library, menu);

        input.get();

        assertTrue(input.isQuit());
    }
}