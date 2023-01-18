package com.sub.learner.javanewfeatures.boxing;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxing {

    public static void main(String[] args) {

        List<Integer> numbers;

        // boxing
        IntStream intStream = IntStream.rangeClosed(0, 5000);
        numbers = intStream.boxed().collect(Collectors.toList());

        // unboxing
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println(sum.get());
        }

        int sum2 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2);

    }

}
