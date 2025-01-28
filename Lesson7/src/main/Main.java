package main;

import coffee.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Kirill");
        board.add("Oleg");
        board.add("Sofia");
        board.add("Maxim");
        board.add("Vlad");
        board.delivery(3);
        board.deliver();
        board.delivery(4);
        board.print();
    }
}