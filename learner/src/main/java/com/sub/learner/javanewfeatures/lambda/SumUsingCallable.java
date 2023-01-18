package com.sub.learner.javanewfeatures.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class SumUsingCallable {

    public static int[] array = IntStream.rangeClosed(0, 5000).toArray();
    public static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> c1 = () -> {
            int sum = 0;
            for (int i = 0; i < array.length / 2; i++) {
                sum += array[i];
            }
            return sum;
        };

        Callable<Integer> c2 = () -> {
            int sum = 0;
            for (int i = array.length / 2; i < array.length; i++) {
                sum += array[i];
            }
            return sum;
        };

        ExecutorService eService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> calls = Arrays.asList(c1, c2);
        List<Future<Integer>> callFutures = eService.invokeAll(calls);

        int callsSum = callFutures.get(0).get() + callFutures.get(1).get();

        System.out.println("Sum result:" + callsSum);
        System.out.println("Verification result:" + total);

        eService.shutdown();
    }

}
