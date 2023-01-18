package com.sub.learner.javanewfeatures.interfaceEx;

public interface InterfaceC extends InterfaceB{
 
    public default void sumC(int num1, int num2) {

        System.out.println("sumC: " + (num1 + num2));
    }

    public default void sumB(int num1, int num2) {

        System.out.println("C.sumB: " + (num1 + num2));
    }

}
