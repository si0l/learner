package com.sub.learner.misc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService ex = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "t1",
                () -> "t2",
                () -> "t3");

        List<Future<String>> futures = ex.invokeAll(callables);

        futures.stream()
                .map((future) -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

    }

}
