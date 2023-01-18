package com.sub.learner.javanewfeatures.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Unmodifiable {

    public static void main(String[] args) {

        // old
        List<String> oldU = new ArrayList<>();
        oldU.add("a");
        oldU.add("b");
        oldU.add("c");
        oldU = Collections.unmodifiableList(oldU);

        // new
        List<String> l = List.of("a", "b", "c");
        Set<String> s = Set.of("a", "b", "c");
        Map<String, String> m = Map.of("a", "a1", "b", "b1", "c", "c1");
        System.out.println("" + l + s + m);

    }

}
