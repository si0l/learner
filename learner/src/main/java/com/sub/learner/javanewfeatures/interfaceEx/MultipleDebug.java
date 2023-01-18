package com.sub.learner.javanewfeatures.interfaceEx;

public class MultipleDebug implements InterfaceA, InterfaceD {

    // override to remove default implementation conflict
    @Override
    public void sumA(int num1, int num2) {
        InterfaceA.super.sumA(num1, num2);
    }
}
