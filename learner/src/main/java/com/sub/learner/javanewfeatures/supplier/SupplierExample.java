package com.sub.learner.javanewfeatures.supplier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<Set<String>> namesSupplier = () -> new HashSet<String>(Arrays.asList("John", "Mary", "Den"));
        System.out.println(namesSupplier.get());

    }

}