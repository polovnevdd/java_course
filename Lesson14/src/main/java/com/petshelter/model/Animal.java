package com.petshelter.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Animal {
    public int num;
    public String name;
    public String type;
    public int age;

    public Animal() {
    }

    public Animal(int num, String name, String type, int age) {
        this.num = num;
        this.name = name;
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString() {
        return "num = " + num +
                ", name = '" + name + '\'' +
                ", type = '" + type + '\'' +
                ", age = " + age;
    }
}
