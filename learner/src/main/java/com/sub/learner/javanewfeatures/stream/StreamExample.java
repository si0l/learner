
package com.sub.learner.javanewfeatures.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class StreamExample {

    public static void main(String[] args) {

        System.out.println("1-------");
        Predicate<Instructor> checkAge = (instructor) -> instructor.getAge() > 30;
        Map<String, List<String>> coursesFilteredByAge =
                Instructors.getAllInstructors().stream()
                        .filter(checkAge)
                        .peek(s -> System.out.println(s)) // used to debug - see all elements in a stream
                        .collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));
        System.out.println(coursesFilteredByAge);

        System.out.println("2-------");
        Stream<String> s = Arrays.asList("s1", "s2").stream();
        s.forEach(System.out::println);

        System.out.println("3-------");
        List<String> names = Instructors.getAllInstructors().stream().map(Instructor::getName).collect(Collectors.toList());
        System.out.println(names);

        System.out.println("4-------");
        Set<String> allCourses = Instructors.getAllInstructors().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream).collect(Collectors.toSet());
        System.out.println(allCourses);

        System.out.println("5-------");
        Instructors.getAllInstructors().stream()
                .sorted(Comparator.comparing(Instructor::getName).reversed()).forEach(System.out::println);

        System.out.println("6------");
        System.out.println(Instructors.getAllInstructors().stream().count());

        System.out.println("7------");
        System.out.println(Instructors.getAllInstructors().stream()
                .map(Instructor::getCourses).flatMap(List::stream).collect(Collectors.toList()));

        System.out.println("8------");
        System.out.println(Instructors.getAllInstructors().stream()
                .map(Instructor::getCourses).flatMap(List::stream).distinct().collect(Collectors.toList()));

        System.out.println("9------");
        System.out.println(Instructors.getAllInstructors().stream()
                .map(Instructor::getCourses).flatMap(List::stream).sorted().collect(Collectors.toList()));

        Predicate<String> p1 = (str) -> str.startsWith("J");

        System.out.println("10------");
        System.out.println(Instructors.getAllInstructors().stream()
                .map(Instructor::getCourses).flatMap(List::stream)
                .anyMatch(p1));

        System.out.println("11------");
        System.out.println(Instructors.getAllInstructors().stream()
                .map(Instructor::getCourses).flatMap(List::stream)
                .allMatch(p1));

        System.out.println("12------");
        System.out.println(Instructors.getAllInstructors().stream()
                .map(Instructor::getCourses).flatMap(List::stream)
                .noneMatch(p1));

        Predicate<Instructor> p2 = (instructor) -> instructor.getAge() > 29;

        System.out.println("13------");
        Instructors.getAllInstructors().stream()
                .filter(p2).sorted(Comparator.comparing(Instructor::getName).reversed()).forEach(System.out::println);

        System.out.println("14------");
        System.out.println(IntStream.rangeClosed(0, 10).reduce(0, (a, b) -> a + b));
        OptionalInt reduceResultOptional = IntStream.rangeClosed(0, 10).reduce((a, b) -> a + b);
        if (reduceResultOptional.isPresent()) {
            System.out.println("Optional reduce result is: " + reduceResultOptional.getAsInt());
        } else {
            System.out.println("Optional reduce result is empty");
        }
        OptionalInt reduceResultOptional2 = IntStream.range(0, 0).reduce((a, b) -> a + b);
        if (reduceResultOptional2.isPresent()) {
            System.out.println("Optional reduce result is: " + reduceResultOptional2.getAsInt());
        } else {
            System.out.println("Optional reduce result is empty");
        }

        System.out.println("15------");
        Optional<Instructor> oldest = Instructors.getAllInstructors().stream().reduce((i1, i2) -> i1.getAge() > i2.getAge() ? i1 : i2);
        if (oldest.isPresent()) {
            System.out.println("Oldest: " + oldest.get().getName());
        } else {
            System.out.println("Oldest: " + oldest.get().getName());
        }

        System.out.println("16------");
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println(max);

        int max2 = IntStream.rangeClosed(0, 10).reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(max2);

        OptionalInt max3 = IntStream.rangeClosed(0, 10).reduce(Integer::max);
        System.out.println(max3);

        System.out.println("17------");
        IntStream.rangeClosed(0, 10).limit(5).forEach(System.out::println);
        IntStream.rangeClosed(0, 10).skip(5).forEach(System.out::println);

        System.out.println("18------");
        System.out.println(Instructors.getAllInstructors().stream().findFirst());
        System.out.println(Instructors.getAllInstructors().stream().findAny());


    }
}
