package com.sub.learner.javanewfeatures.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class Mapping {

    public static void main(String[] args) {

        System.out.println(Instructors.getAllInstructors().stream()
                .collect(Collectors.mapping(i -> i.getName(), Collectors.toList())));

        Map<Integer, List<String>> map = Instructors.getAllInstructors().stream()
                .collect(Collectors.groupingBy(Instructor::getAge, Collectors.mapping(Instructor::getName, Collectors.toList())));
        map.keySet().forEach(k -> System.out.println("key: " + k + ", value: " + map.get(k)));
    }
}
