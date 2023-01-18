package com.sub.learner.javanewfeatures.interfaceEx;

public interface InterfaceB extends InterfaceA {

    public default void sumB(int num1, int num2) {

        System.out.println("sumB: " + (num1 + num2));
    }

    default void sumA(int num1, int num2) {

        System.out.println("B.sumA: " + (num1 + num2));
    }

}
