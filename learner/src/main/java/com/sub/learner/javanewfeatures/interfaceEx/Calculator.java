package com.sub.learner.javanewfeatures.interfaceEx;

public interface Calculator {

    public int sum(int num1, int num2);

    public default double divide(int num1, int num2) {

        return (double) num1 / num2;
    }

    public default int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

}
