package main;

import animals.Animals;
import animals.Cat;
import animals.Dog;

public class Main {
    public static void main(String[] args) {
        Animals Bobik = new Dog("Бобик");
        Animals Rotor = new Dog("Ротор");
        Animals Bublik = new Cat("Бублик");
        Animals Sharik = new Cat("Шарик");
        Bobik.swim(11);
        Bobik.run(300);
        Rotor.run(550);
        Bublik.run(150);
        Sharik.swim(0);
        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество котов: " + Cat.getCount());
        System.out.println("Количество животных: " + Animals.getAnimalsCount());
    }
}