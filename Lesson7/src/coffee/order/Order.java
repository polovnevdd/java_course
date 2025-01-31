package coffee.order;

public class Order {
    private int orderNumber;
    private String customerName;

    public Order(String customerName, int orderNumber) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void print(Order print) {
        System.out.println(print);
    }

    @Override
    public String toString() {
        return customerName + " | " + orderNumber;
    }
}
