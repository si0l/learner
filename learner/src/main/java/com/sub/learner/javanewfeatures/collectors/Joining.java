package com.sub.learner.javanewfeatures.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Joining {

    public static void main(String[] args) {

        String r1 = Stream.of("a", "b", "c").collect(Collectors.joining());
        System.out.println(r1);
        String r2 = Stream.of("a", "b", "c").collect(Collectors.joining(","));
        System.out.println(r2);
        String r3 = Stream.of("a", "b", "c").collect(Collectors.joining(",", "{", "}"));
        System.out.println(r3);

    }

}
