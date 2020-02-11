package com.twu.biblioteca.view;

import java.util.Scanner;

public class InputReceiver {

    private static final InputReceiver inputReceiver = new InputReceiver();
    private Scanner scanner;

    private InputReceiver(){
    }

    public static InputReceiver getInputReceiver(){
        if (inputReceiver.scanner == null){
            inputReceiver.scanner = new Scanner(System.in);
        }
        return inputReceiver;
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void reset() {
        scanner.close();
        scanner = null;
    }

    public boolean isClosed() {
        return scanner == null;
    }
}
