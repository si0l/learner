package com.sub.learner.javanewfeatures.collectors;

import java.util.stream.Collectors;
import com.sub.learner.javanewfeatures.model.Instructors;

public class Counting {

    public static void main(String[] args) {

        System.out.println(Instructors.getAllInstructors().stream().filter((i) -> i.getAge() > 30)
                .collect(Collectors.counting()));

    }

}
