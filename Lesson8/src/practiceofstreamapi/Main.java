package practiceofstreamapi;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Product> filterBooksByPrice(List<Product> products, double price) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() > price)
                .collect(Collectors.toList());
    }

    public static List<Product> filterBooksByDiscount(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getDiscount() == true)
                .peek(p -> p.applyDiscount())
                .collect(Collectors.toList());
    }

    public static Product takeCheapestPrice(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .sorted(Comparator.comparing(p -> p.getPrice()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }

    public static List<Product> getLastTreeProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double sumOfProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() <= 75 && p.getDate().getYear() == 2024)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.getType()));
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Book", 300, true, LocalDate.of(2021, 9, 26)),
                new Product("Toy", 50, false, LocalDate.of(2024, 7, 12)),
                new Product("Toy", 150, false, LocalDate.of(2022, 8, 2)),
                new Product("Book", 50, true, LocalDate.of(2024, 5, 6)),
                new Product("Phone", 500, true, LocalDate.of(2020, 4, 21)),
                new Product("Phone", 600, true, LocalDate.of(2021, 1, 1)),
                new Product("Book", 70, true, LocalDate.of(2024, 10, 11))
        );
        System.out.println(filterBooksByPrice(products, 250));
        System.out.println(filterBooksByDiscount(products));
        System.out.println(takeCheapestPrice(products));
        System.out.println(getLastTreeProducts(products));
        System.out.println(sumOfProducts(products));
        System.out.println(groupByType(products));
    }
}