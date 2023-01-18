package com.sub.learner.javanewfeatures.mapto;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MapTo {

    public static void main(String[] args) {

        List<RandomNumber> rIds = IntStream.rangeClosed(0, 5)
                .mapToObj((a) -> {
                    return new RandomNumber(a, ThreadLocalRandom.current().nextInt(100));
                }).collect(Collectors.toList());

        rIds.forEach(System.out::println);

        LongStream ls = IntStream.range(0, 5).mapToLong(a -> (long) a);
        ls.forEach(System.out::println);

    }

    static class RandomNumber {

        int id;
        int randomNumber;

        public RandomNumber(int id, int randomNumber) {
            this.id = id;
            this.randomNumber = randomNumber;
        }

        @Override
        public String toString() {
            return "RandomIds [id=" + id + ", randomNumber=" + randomNumber + "]";
        }

    }

}
