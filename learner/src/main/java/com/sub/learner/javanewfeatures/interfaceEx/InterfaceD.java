package com.sub.learner.javanewfeatures.interfaceEx;

public interface InterfaceD {

    default void sumA(int num1, int num2) {

        System.out.println("A.sumA: " + (num1 + num2));
    }

}
