package com.sub.learner.javanewfeatures.functional;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        BiConsumer<String, String> bc = (x, y) -> System.out.println(x + " " + y);
        bc.accept("hi", "friend");

    }

}
