package com.sub.learner.javanewfeatures.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class FunctionExample {

    public static void main(String[] args) {

        System.out.println("1-------");
        Function<Integer, Double> f1 = (number) -> Math.sqrt(number);
        Function<Integer, Double> f11 = Math::sqrt;
        System.out.println(f1.apply(10));
        System.out.println(f11.apply(13));

        System.out.println("2-------");
        Function<Integer, Integer> f2 = (number) -> number + 10;
        System.out.println(f1.compose(f2).apply(90));
        System.out.println(f2.andThen(f1).apply(90));

        System.out.println("3-------");
        Function<List<Instructor>, Map<String, Integer>> f3 = (instructors) -> {
            Map<String, Integer> iMap = new HashMap<>();
            instructors.forEach((instructor) -> {
                iMap.put(instructor.getName(), instructor.getAge());
            });

            return iMap;
        };
        System.out.println(f3.apply(Instructors.getAllInstructors()));

        System.out.println("4-------");
        Predicate<Instructor> p1 = (instructor) -> instructor.getAge() > 30;
        Function<List<Instructor>, Map<String, Integer>> f4 = (instructors) -> {
            Map<String, Integer> iMap = new HashMap<>();
            instructors.forEach((instructor) -> {
                if (p1.test(instructor)) {
                    iMap.put(instructor.getName(), instructor.getAge());
                }
            });

            return iMap;
        };
        System.out.println(f4.apply(Instructors.getAllInstructors()));

        System.out.println("5-------");
        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String, Integer>> biF1 = (instructors, predicate) -> {

            Map<String, Integer> iMap = new HashMap<>();
            instructors.forEach((instructor) -> {
                if (predicate.test(instructor)) {
                    iMap.put(instructor.getName(), instructor.getAge());
                }
            });

            return iMap;

        };

        System.out.println(biF1.apply(Instructors.getAllInstructors(), p1));
    }

}
