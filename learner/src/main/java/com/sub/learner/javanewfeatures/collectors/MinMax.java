package com.sub.learner.javanewfeatures.collectors;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class MinMax {

    public static void main(String[] args) {

        Optional<Instructor> min = Instructors.getAllInstructors().stream()
                .collect(Collectors.minBy(Comparator.comparing(Instructor::getAge)));
        System.out.println(min);

        Optional<Instructor> max = Instructors.getAllInstructors().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Instructor::getAge)));
        System.out.println(max);

    }
}
