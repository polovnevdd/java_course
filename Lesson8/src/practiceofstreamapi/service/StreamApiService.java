package practiceofstreamapi.service;

import practiceofstreamapi.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamApiService {
    public static List<Product> filterBooksByPrice(List<Product> products, double price) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() > price)
                .collect(Collectors.toList());
    }

    public static List<Product> filterBooksByDiscount(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.isDiscounted())
                .peek(p -> p.applyDiscount())
                .collect(Collectors.toList());
    }

    public static Product takeCheapestPrice(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
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

}
