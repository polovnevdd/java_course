package com.calculator;

public class Calculator {
    public static void main(String[] args) {
        new Calculator().run(args);
        Car car = new Car();
    }

    private void run(String[] args) {
        float firstNum = Float.parseFloat(args[0]);
        float secondNum = Float.parseFloat(args[1]);
        String operator = args[2];
        System.out.println(operator);
        switch (operator) {
            case "+":
                printResult(firstNum + secondNum);
                break;
            case "-":
                printResult(firstNum - secondNum);
                break;
            case "/":
                printResult(firstNum / secondNum);
                break;
            case "x":
                printResult(firstNum * secondNum);
                break;
            default:
                System.out.println("No such operator");
        }
    }

    private void printResult(float result) {
        System.out.println("Result: " + result);
    }
}
