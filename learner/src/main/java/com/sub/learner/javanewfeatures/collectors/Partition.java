package com.sub.learner.javanewfeatures.collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class Partition {

    public static void main(String[] args) {

        Predicate<Instructor> byAge = (instructor) -> instructor.getAge() > 30;

        Map<Boolean, List<Instructor>> res = Instructors.getAllInstructors().stream()
                .collect(Collectors.partitioningBy(byAge));
        res.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));

        Map<Boolean, Set<Instructor>> resSet = Instructors.getAllInstructors().stream()
                .collect(Collectors.partitioningBy(byAge, Collectors.toSet()));
        resSet.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));

    }
}
