package com.sub.learner.javanewfeatures.stream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericAggregate {
    
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(0, 1000).sum());
        OptionalInt min = IntStream.rangeClosed(0, 1000).min();
        if(min.isPresent()){
            System.out.println(min.getAsInt());
        } else {
            System.out.println("No min value");
        }
        OptionalDouble average = LongStream.rangeClosed(0, 1000).asDoubleStream().average();
        if(average.isPresent()){
            System.out.println(average.getAsDouble());
        } else {
            System.out.println("No average value");
        }
    }

}
