package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    List<Order> orders;
    int orderNumber = 1;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
    }

    public void add(String customerName) {
        orders.add(new Order(customerName, orderNumber));
        orderNumber++;
    }

    public void print() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void deliver() {
        System.out.println(orders.get(0));
        orders.remove(0);
    }

    public void delivery(int numOfOrder) {
        int temp = 0;
        for (Order order : orders) {
            if (order.getOrderNumber() == numOfOrder) {
                System.out.println(orders.get(temp));
                orders.remove(temp);
                break;
            }
            temp++;
        }
    }

}
