package com.gameshop.enums;

public enum Menu {
    ADD_GAME("ADD_GAME"),
    DELETE_GAME("DELETE_GAME"),
    SEARCH_GAME("SEARCH_GAME"),
    FILTER_BY_PRICE("FILTER_BY_PRICE"),
    FILTER_BY_TYPE("FILTER_BY_TYPE"),
    SHOW_BY_DATE("SHOW_BY_DATE"),
    SHOW_ALL("SHOW_ALL"),
    EXIT("EXIT");

    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    static public Menu getByDescription(String description) {
        for (Menu value : Menu.values()) {
            if (description.equals(value.getDescription())) {
                return value;
            }
        }
        return null;
    }
}
