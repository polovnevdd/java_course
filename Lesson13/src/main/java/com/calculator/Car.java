package com.calculator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car {
    String name;
    int year;

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
