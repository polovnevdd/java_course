package com.petshelter.model;

public enum  Menu {
    ADD_PET("add pet"),
    SHOW_ALL("show all"),
    TAKE_PET("take pet"),
    EXIT("exit");

    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
