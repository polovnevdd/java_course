package com.gameshop;

import com.gameshop.enums.Menu;
import com.gameshop.model.Game;
import com.gameshop.service.GameShop;
import com.gameshop.service.impl.DefaultGameShop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        GameShop gameShop = new DefaultGameShop();
        while (true) {
            System.out.println("* Меню: \n");
            showMenu();
            System.out.print("* Выберите пункт меню: ");
            String choice = scanner.next();
            Menu menuChoice = Menu.getByDescription(choice);
            if (menuChoice == null) {
                System.out.println("Неправильный выбор");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            switch (menuChoice) {
                case ADD_GAME -> add(scanner, formatter, gameShop);

                case DELETE_GAME -> delete(scanner, gameShop);

                case SEARCH_GAME -> searchByName(scanner, gameShop);

                case FILTER_BY_PRICE -> filterByPrice(scanner, gameShop);

                case FILTER_BY_TYPE -> filterByType(scanner, gameShop);

                case SHOW_BY_DATE -> sortByDate(gameShop);

                case SHOW_ALL -> showAll(gameShop);

                case EXIT -> {
                    System.out.println("* Выход");
                    return;
                }
            }
        }

    }

    private void sortByDate(GameShop gameShop) {
        System.out.println(gameShop.showByDate());
    }

    private void filterByType(Scanner scanner, GameShop gameShop) {
        String type;
        System.out.print("Введите тип по которому хотите отфильтровать: ");
        type = scanner.next();
        System.out.println(gameShop.filterByType(type));
    }

    private void filterByPrice(Scanner scanner, GameShop gameShop) {
        int price;
        System.out.print("Введите цену по которой хотить отфильтровать: ");
        price = scanner.nextInt();
        System.out.println(gameShop.filterByPrice(price));
    }

    private void searchByName(Scanner scanner, GameShop gameShop) {
        String name;
        System.out.print("Введите название игры: ");
        name = scanner.next();
        Game result = gameShop.showByName(name);
        if (result != null) {
            System.out.println(result);
        }
    }

    private void delete(Scanner scanner, GameShop gameShop) {
        int id;
        System.out.print("Введите id игры, которую хотите удалить: ");
        id = scanner.nextInt();
        gameShop.delete(id);
    }

    private void showAll(GameShop gameShop) {
        System.out.println("Все игры: \n" + gameShop.showAll());
    }

    private void add(Scanner scanner, DateTimeFormatter formatter, GameShop gameShop) {
        float rating;
        String releaseDate;
        float cost;
        String description;
        String type;
        String name;
        System.out.print("Введите название игры: ");
        name = scanner.next();
        System.out.print("Введите дату релиза игры: ");
        releaseDate = scanner.next();
        System.out.print("Введите рейтинг игры: ");
        rating = scanner.nextFloat();
        System.out.print("Введите цену игры: ");
        cost = scanner.nextFloat();
        System.out.print("Введите описание игры: ");
        description = scanner.next();
        System.out.print("Введите тип игры: ");
        type = scanner.next();
        Game game = new Game(name, LocalDate.parse(releaseDate, formatter), rating, cost, description, type);
        gameShop.add(game);
    }

    private void showMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println("* " + menu.getDescription());
        }
        System.out.println();
    }
}
