package com.sub.learner.javanewfeatures.interfaceEx;

public class MathOperationExample implements Calculator {

    public static void main(String[] args) {

        MathOperationExample mathOperationExample = new MathOperationExample();
        System.out.println("sum: " + mathOperationExample.sum(1, 2));
        System.out.println("divide: " + mathOperationExample.divide(1, 2));

        Calculator c = (num1, num2) -> num1%num2;
        System.out.println("sum2: " + c.sum(1, 2));

        System.out.println("multiply: " + Calculator.multiply(1, 2));

    }

    public int sum(int num1, int num2) {

        return num1 + num2;
    }

}
