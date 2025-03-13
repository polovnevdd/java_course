package com.petshelter;

import com.petshelter.model.Animal;
import com.petshelter.model.Menu;
import com.petshelter.service.AnimalSerializer;
import com.petshelter.service.ShelterManager;

import java.util.List;
import java.util.Scanner;

public class ShelterApp {
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        ShelterManager shelterManager = new ShelterManager();
        AnimalSerializer animalSerializer = new AnimalSerializer();
        List<Animal> listOfAnimal = animalSerializer.deserialize();
        int petNum = listOfAnimal.get(listOfAnimal.size() - 1).getNum() + 1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "add pet":
                    shelterManager.addPet(listOfAnimal, petNum);
                    System.out.println("Питомец добавлен в приют!");
                    petNum++;
                    break;
                case "show all":
                    System.out.println("Список всех питомцев в приюте:");
                    shelterManager.showAll(listOfAnimal);
                    break;
                case "take pet":
                    shelterManager.takePet(listOfAnimal);
                    break;
                case "exit":
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
