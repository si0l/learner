package com.sub.learner.javanewfeatures.functional;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class NumberConsumersExample {

    public static void main(String[] args) {

        IntConsumer ic = (x) -> System.out.println(x + 1);
        DoubleConsumer dc = (x) -> System.out.println(x / 3);
        LongConsumer lc = (x) -> System.out.println(x * 10L);

        ic.accept(3);
        dc.accept(3.1);
        lc.accept(3L);
    }

}