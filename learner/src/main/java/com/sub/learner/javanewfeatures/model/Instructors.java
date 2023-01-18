package com.sub.learner.javanewfeatures.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Instructors {

    public static List<Instructor> getAllInstructors() {

        List<Instructor> instructors = new ArrayList<>();

        instructors.add(new Instructor("John", 30, Arrays.asList("Java", "C++")));
        instructors.add(new Instructor("May", 25, Arrays.asList("Spring", "Python")));
        instructors.add(new Instructor("Dan", 40, Arrays.asList("Docker", "SAP", "Java")));
        instructors.add(new Instructor("Pete", 40, Arrays.asList("Java", "JavaScript")));

        return instructors;
    }

}
