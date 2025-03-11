package com.calculator;

public class Calculator {
    public static void main(String[] args) {
        new Calculator().run(args);
    }

    private void run(String[] args) {
        float firstNum = Integer.parseInt(args[0]);
        float secondNum = Integer.parseInt(args[1]);
        String operator = args[2];
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
            case "*":
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
