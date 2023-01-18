package com.sub.learner.javanewfeatures.interfaceEx;

public class MultipleInheritence implements InterfaceA, InterfaceB, InterfaceC {

    public static void main(String[] args) {

        MultipleInheritence inst = new MultipleInheritence();

        inst.sumA(1, 2); // resolves to child (InterfaceB)
        inst.sumB(1, 2); // resolves to own implementation
        inst.sumC(1, 2);
    }

    public void sumB(int num1, int num2) {
        System.out.println("MultipleInheritence.sumB:" + (num1 + num2));
    }
}
