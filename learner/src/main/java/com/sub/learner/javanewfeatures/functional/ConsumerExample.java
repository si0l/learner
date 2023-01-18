package com.sub.learner.javanewfeatures.functional;

import java.util.function.Consumer;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class ConsumerExample {

    public static void main(String[] args) {

        System.out.println("1-------");
        Consumer<String> c = (x) -> System.out.println(x);
        c.accept("hi");

        System.out.println("2-------");
        Consumer<Instructor> c1 = (x) -> System.out.println(x);
        Instructors.getAllInstructors().forEach(c1);

        System.out.println("3-------");
        Consumer<Instructor> c2 = (x) -> System.out.println(x.getName());
        Instructors.getAllInstructors().forEach(c2);

        System.out.println("4-------");
        Consumer<Instructor> c3 = (x) -> System.out.println(x.getCourses());
        Instructors.getAllInstructors().forEach(c2.andThen(c3));

        System.out.println("5-------");
        Instructors.getAllInstructors().forEach((x) -> {
            if (x.getAge() > 29) {
                c2.andThen(c3).accept(x);
            }
        });

    }

}
