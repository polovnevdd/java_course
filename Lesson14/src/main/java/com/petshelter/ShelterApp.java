package com.petshelter;

import com.petshelter.model.Animal;
import com.petshelter.model.Menu;
import com.petshelter.service.AnimalSerializer;
import com.petshelter.service.ShelterManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShelterApp {
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        List<Animal> listOfAnimal = new ArrayList<>();
        ShelterManager shelterManager = new ShelterManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "add pet":
                    shelterManager.addPet(listOfAnimal);
                    System.out.println("Питомец добавлен в приют!");
                    break;
                case "show all":
                    System.out.println("Список всех питомцев в приюте:");
                    shelterManager.showAll(listOfAnimal);
                    break;
                case "take pet":
                    shelterManager.takePet(listOfAnimal);
                    break;
                case "exit":
                    AnimalSerializer animalSerializer = new AnimalSerializer();
                    animalSerializer.serialize(shelterManager.getListOfPets(listOfAnimal));
                    System.out.println("Выход");
                    return;
                default:
                    System.out.println("Неправильный выбор");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println(menu.getDescription());
        }
    }


}
