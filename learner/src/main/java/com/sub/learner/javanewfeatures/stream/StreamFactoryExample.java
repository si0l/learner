package com.sub.learner.javanewfeatures.stream;

import java.util.Random;
import java.util.stream.Stream;

public class StreamFactoryExample {

    public static void main(String[] args) {

        System.out.println("1--------");
        Stream.of(1, 2, 3, 4, 5, 6).forEach(System.out::println);;
        System.out.println("2--------");
        Stream.of(new Integer[] {1, 2, 3, 4, 5, 6}).forEach(System.out::println);;

        System.out.println("3--------");
        Stream.iterate(0, i -> i + 2).limit(10).forEach(System.out::println);

        System.out.println("4--------");
        Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);
    }

}
