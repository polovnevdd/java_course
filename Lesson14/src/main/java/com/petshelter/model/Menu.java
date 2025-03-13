package com.petshelter.model;

public enum Menu {
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

    static public Menu getByDescription(String description) {
        for(Menu value : Menu.values()) {
            if (description.equals(value.getDescription())) {
                return value;
            }
        }
        return null;
    }
}
