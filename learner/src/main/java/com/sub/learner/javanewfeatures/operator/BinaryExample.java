package com.sub.learner.javanewfeatures.operator;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class BinaryExample {

    public static void main(String[] args) {

        BinaryOperator<String> op = (text1, text2) -> text1 + text2;
        System.out.println(op.apply("text1", "text2"));

        Comparator<String> comparator = (text1, text2) -> text1.compareTo(text2);
        BinaryOperator<String> biMax = BinaryOperator.maxBy(comparator);
        BinaryOperator<String> biMin = BinaryOperator.minBy(comparator);
        System.out.println(biMax.apply("abgi", "cdef"));
        System.out.println(biMin.apply("abc", "def"));

        IntBinaryOperator iOp = (n1, n2) -> n1 + n2;
        System.out.println(iOp.applyAsInt(3, 5));

        LongBinaryOperator lOp = (n1, n2) -> n1 + n2;
        System.out.println(lOp.applyAsLong(3, 10));

        DoubleBinaryOperator dOp = (n1, n2) -> n1 + n2;
        System.out.println(dOp.applyAsDouble(1.4, 3.5));
    }

}
