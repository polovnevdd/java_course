package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders;
    private int orderNumber = 1;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
    }

    public void add(String customerName) {
        orders.add(new Order(customerName, orderNumber));
        orderNumber++;
    }

    public void draw() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void deliver() {
        Order order = orders.get(0);
        order.print(order);
        orders.remove(0);
    }

    public void deliver(int numOfOrder) {
        int temp = 0;
        for (Order order : orders) {
            if (order.getOrderNumber() == numOfOrder) {
                order.print(orders.get(temp));
                orders.remove(temp);
                break;
            }
            temp++;
        }
    }

}
