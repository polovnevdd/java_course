package practiceofstreamapi;

import practiceofstreamapi.model.Product;
import practiceofstreamapi.service.StreamApiService;

import java.time.LocalDate;
import java.util.*;

public class Main {

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
        System.out.println(StreamApiService.filterBooksByPrice(products, 250));
        System.out.println(StreamApiService.filterBooksByDiscount(products));
        System.out.println(StreamApiService.takeCheapestPrice(products));
        System.out.println(StreamApiService.getLastTreeProducts(products));
        System.out.println(StreamApiService.sumOfProducts(products));
        System.out.println("{");
        for (Map.Entry<String, List<Product>> entry : StreamApiService.groupByType(products).entrySet()) {
            System.out.println("  \"" + entry.getKey() + "\": [");
            for (Product product : entry.getValue()) {
                System.out.println("    " + product + ",");
            }
            System.out.println("  ],");
        }
        System.out.println("}");
    }
}