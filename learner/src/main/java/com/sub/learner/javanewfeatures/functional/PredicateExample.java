package com.sub.learner.javanewfeatures.functional;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class PredicateExample {

    public static void main(String[] args) {

        System.out.println("1---------");
        Predicate<Integer> p1 = (number) -> number > 10;
        System.out.println(p1.test(11));

        System.out.println("2---------");
        Predicate<Integer> p2 = (number) -> number % 2 == 0;
        System.out.println(p1.and(p2).test(11));
        System.out.println(p1.and(p2).test(12));
        System.out.println(p1.or(p2).test(11));

        System.out.println("3---------");
        Predicate<Instructor> p3 = (instructor) -> instructor.getAge() > 30;
        Instructors.getAllInstructors().forEach((instructor) -> {
            if (p3.test(instructor)) {
                System.out.println(instructor);
            }
        });

        System.out.println("4---------");
        IntPredicate p4 = (number) -> number > 10;
        DoublePredicate p5 = (number) -> number > 10.1;
        LongPredicate p6 = (number) -> number > 100L;
        System.out.println(p4.test(11));
        System.out.println(p5.test(9.3));
        System.out.println(p6.test(101L));

        System.out.println("5---------");
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println("name: " + name + ", age: " + age);
        Instructors.getAllInstructors().forEach((instructor) -> {
            if (p3.test(instructor)) {
                biConsumer.accept(instructor.getName(), instructor.getAge());
            }
        });

        System.out.println("6---------");
        BiPredicate<Integer, Double> biPredicate = (iNumber, dNumber) -> iNumber < 10 && dNumber > 10;
        System.out.println(biPredicate.test(9, 10.1));

    }

}
