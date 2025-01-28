package coffee.order;

public class Order {
    int orderNumber;
    String customerName;

    public Order(String customerName, int orderNumber) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return customerName + " | " + orderNumber;
    }
}
