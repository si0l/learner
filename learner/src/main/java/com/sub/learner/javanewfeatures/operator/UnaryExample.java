package com.sub.learner.javanewfeatures.operator;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryExample {

    public static void main(String[] args) {

        UnaryOperator<String> u = (text) -> text + " length is: " + text.length();
        System.out.println(u.apply("test text"));

        IntUnaryOperator iu = (number) -> number + 10;
        System.out.println(iu.applyAsInt(39));

        LongUnaryOperator lu = (number) -> number + 10L;
        System.out.println(lu.applyAsLong(39L));

        DoubleUnaryOperator du = (number) -> number + 10.1;
        System.out.println(du.applyAsDouble(39.1));

    }

}
