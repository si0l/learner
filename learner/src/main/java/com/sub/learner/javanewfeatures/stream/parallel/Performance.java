package com.sub.learner.javanewfeatures.stream.parallel;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Performance {

    private static int TOKEN_COUNT = 500000;

    public static void main(String[] args) {

        System.out.println("seq: " + measure(Performance::sortSeq, 100));
        System.out.println("par: " + measure(Performance::sortPar, 100));

    }

    public static long measure(Supplier<Long> sup, int num) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            sup.get();
        }

        long end = System.currentTimeMillis();

        return end - start;

    }

    public static long sortSeq() {

        List<RandomToken> tokens =
                LongStream.rangeClosed(0, TOKEN_COUNT)
                        .mapToObj(i -> {
                            return new RandomToken(i, ThreadLocalRandom.current().nextLong(TOKEN_COUNT));
                        })
                        .collect(Collectors.toList());

        tokens.stream().sorted(Comparator.comparing(RandomToken::getToken));

        return -1;

    }

    public static long sortPar() {

        List<RandomToken> tokens =
                LongStream.rangeClosed(0, TOKEN_COUNT).parallel()
                        .mapToObj(i -> {
                            return new RandomToken(i, ThreadLocalRandom.current().nextLong(TOKEN_COUNT));
                        })
                        .collect(Collectors.toList());

        tokens.stream().parallel().sorted(Comparator.comparing(RandomToken::getToken));

        return -1;

    }

    static class RandomToken {

        long id;
        long token;

        public RandomToken(long id, long token) {
            this.id = id;
            this.token = token;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getToken() {
            return token;
        }

        public void setToken(long token) {
            this.token = token;
        }


    }

}
