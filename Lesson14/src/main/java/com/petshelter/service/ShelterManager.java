package com.petshelter.service;

import com.petshelter.model.Animal;

import java.util.List;
import java.util.Scanner;

public class ShelterManager {
    int petNum = 1;

    public void addPet(List<Animal> listOfPets) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String petName = scanner.nextLine();
        System.out.println("Введите тип питомца:");
        String petType = scanner.nextLine();
        System.out.println("Введите возраст:");
        int petAge = scanner.nextInt();
        listOfPets.add(new Animal(petNum, petName, petType, petAge));
        petNum++;
    }

    public void showAll(List<Animal> listOfPets) {
        for (Animal pet : listOfPets) {
            System.out.println(pet);
        }
    }

    public void takePet(List<Animal> listOfPets) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер питомца, которого хотите забрать:");
        int petNum = scanner.nextInt();
        for (Animal pet : listOfPets) {
            if (pet.getNum() == petNum) {
                listOfPets.remove(pet);
            }
        }
    }

    public List<Animal> getListOfPets(List<Animal> listOfPets) {
        return listOfPets;
    }
}
