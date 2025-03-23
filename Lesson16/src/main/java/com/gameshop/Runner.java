package com.gameshop;

import com.gameshop.service.GameShop;
import com.gameshop.service.impl.DefaultGameShop;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
    }

    private void run() {
        Runner runner = new Runner();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("* Меню:");
            System.out.println();
            runner.showMenu();
            System.out.println();
            System.out.print("* Выберите пункт меню: ");
            String choice = scanner.nextLine();
            Menu menuChoice = Menu.getByDescription(choice);
            if (menuChoice == null) {
                System.out.println("Неправильный выбор");
            }
            GameShop gameShop = new DefaultGameShop();

            switch (menuChoice) {
                case ADD_GAME:
                    gameShop.add();
                    break;
                case DELETE_GAME:
                    gameShop.delete();
                    break;
                case SEARCH_GAME:
                    gameShop.showByName();
                    break;
                case FILTER_BY_PRICE:
                    gameShop.filterByPrice();
                    break;
                case FILTER_BY_TYPE:
                    gameShop.filterByType();
                    break;
                case SHOW_BY_DATE:
                    gameShop.showByDate();
                    break;
                case SHOW_ALL:
                    gameShop.showAll();
                    break;
                case EXIT:
                    System.out.println("* Выход");
                    return;
            }
        }

    }

    private void showMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println("* " + menu.getDescription());
        }
    }
}
