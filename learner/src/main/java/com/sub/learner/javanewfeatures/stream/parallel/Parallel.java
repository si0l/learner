package com.sub.learner.javanewfeatures.stream.parallel;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Parallel {

    public static void main(String[] args) {

        System.out.println("Seq: " + sequential());
        System.out.println("Par: " + parallel());

        int number = 1150;
        long parMeasure = measurePerf(Parallel::parallel, number);
        long seqMeasure = measurePerf(Parallel::sequential, number);

        System.out.println("seq perf: " + seqMeasure);
        System.out.println("par perf: " + parMeasure);

    }

    public static long measurePerf(Supplier<Integer> sup, int number) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            sup.get();
        }
        long end = System.currentTimeMillis();

        return end - start;

    }

    public static int sequential() {
        return IntStream.range(0, 50000).sum();
    }

    public static int parallel() {
        return IntStream.range(0, 50000).parallel().sum();
    }
}
