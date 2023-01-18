package com.sub.learner.javanewfeatures.optional;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

public class OptionalExample {

    public static void main(String[] args) {

        System.out.println("1---");
        Integer[] numbers = new Integer[10];
        try {
            System.out.println(numbers[1].intValue());
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        System.out.println("2---");
        Optional<Integer> op1 = Optional.ofNullable(numbers[1]);
        System.out.println(op1.isPresent() ? op1.get() : "value is empty");

        System.out.println("3---");
        Optional<String> op2 = Optional.of("Hi");
        System.out.println(op2);

        System.out.println("4---");
        try {
            Optional<String> op3 = Optional.of(null);
            System.out.println(op3);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        System.out.println("5---");
        System.out.println(getWords());

        System.out.println("6---");
        System.out.println(op1.orElse(-10));

        System.out.println("7---");
        System.out.println(op1.orElseGet(new Random()::nextInt));

        System.out.println("8---");
        try {
            op1.orElseThrow(() -> new Exception());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("9---");
        Consumer<Object> c = v -> System.out.println(v);
        op1.ifPresent(c);
        op2.ifPresent(c);

    }

    static Optional<String> getWords() {

        String[] words = new String[10];
        Optional<String> op = Optional.ofNullable(words[1]);

        if (op.isPresent()) {

            return op;
        } else {

            return Optional.empty();
        }
    }

}
