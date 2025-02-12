package practiceofstreamapi.model;

import java.time.LocalDate;

public class Product {
    private String type;
    private double price;
    private boolean discount;

    private LocalDate date;

    public Product(String type, int price, boolean discount, LocalDate date) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscounted() {
        return discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void applyDiscount() {
        this.price = getPrice() * 0.9;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
