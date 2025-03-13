package com.petshelter.service;

import com.petshelter.model.Animal;

import java.util.List;
import java.util.Scanner;

public class ShelterManager {

    public void addPet(List<Animal> listOfPets, int petNum) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String petName = scanner.nextLine();
        System.out.print("Введите тип питомца: ");
        String petType = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int petAge = scanner.nextInt();
        listOfPets.add(new Animal(petNum, petName, petType, petAge));
    }

    public void showAll(List<Animal> listOfPets) {
        for (Animal pet : listOfPets) {
            System.out.println(pet);
        }
    }

    public void takePet(List<Animal> listOfPets) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер питомца, которого хотите забрать: ");
        int petNum = scanner.nextInt();
        listOfPets.removeIf(pet -> pet.getNum() == petNum);
    }

    public List<Animal> getListOfPets(List<Animal> listOfPets) {
        return listOfPets;
    }
}
