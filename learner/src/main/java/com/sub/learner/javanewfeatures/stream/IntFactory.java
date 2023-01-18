package com.sub.learner.javanewfeatures.stream;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntFactory {

    public static void main(String[] args) {
        IntStream is1 = IntStream.of(1, 2, 3, 4, 5);
        IntStream is2 = IntStream.iterate(0, (a) -> a + 2).limit(5);
        IntStream is3 = IntStream.generate(new Random()::nextInt).limit(5);
        IntStream is4 = IntStream.range(0, 5);
        is1.forEach(System.out::println);
        is2.forEach(System.out::println);
        is3.forEach(System.out::println);
        is4.forEach(System.out::println);

        DoubleStream ds1 = LongStream.rangeClosed(0, 5).asDoubleStream();
        ds1.forEach(System.out::println);
    }

}
