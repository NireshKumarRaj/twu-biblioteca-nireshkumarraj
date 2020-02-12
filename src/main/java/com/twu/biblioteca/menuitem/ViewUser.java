package com.twu.biblioteca.menuitem;

public class ViewUser implements MenuItem, Auth {

    private final String name;

    public ViewUser() {
        name = "View My Info";
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return name;
    }
}
