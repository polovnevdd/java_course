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
            System.out.println("Меню:");
            showMenu();
            System.out.print("Выберите пункт меню: ");
            String choice = scanner.nextLine();
            Menu menuChoice = Menu.getByDescription(choice);
            if(menuChoice == null) {
                System.out.println("Неправильный выбор");
            }

            switch (menuChoice) {
                case ADD_PET:
                    shelterManager.addPet(listOfAnimal, petNum);
                    System.out.println("Питомец добавлен в приют!");
                    petNum++;
                    break;
                case SHOW_ALL:
                    System.out.println("Список всех питомцев в приюте:");
                    shelterManager.showAll(listOfAnimal);
                    break;
                case TAKE_PET:
                    shelterManager.takePet(listOfAnimal);
                    break;
                case EXIT:
                    animalSerializer.serialize(shelterManager.getListOfPets(listOfAnimal));
                    System.out.println("Выход");
                    return;
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
