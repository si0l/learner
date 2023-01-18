package com.sub.learner.javanewfeatures.collectors;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class GroupingBy {

    public static void main(String[] args) {

        System.out.println("1---");
        Map<Integer, List<Instructor>> groupByNameLength =
                Instructors.getAllInstructors().stream().collect(Collectors.groupingBy(i -> i.getName().length()));
        groupByNameLength.forEach((key, value) -> System.out.println("length: " + key + ", value: " + value));

        System.out.println("2---");
        Map<Integer, List<Instructor>> groupAndFilter = Instructors.getAllInstructors().stream()
                .collect(Collectors.groupingBy(i -> i.getName().length(),
                        Collectors.filtering(i -> i.getAge() > 30, Collectors.toList())));
        groupAndFilter.forEach((key, value) -> System.out.println("length: " + key + ", value: " + value));

        System.out.println("3---");
        LinkedHashMap<Integer, List<Instructor>> groupAndFilter2 = Instructors.getAllInstructors().stream()
                .collect(Collectors.groupingBy(i -> i.getName().length(), LinkedHashMap::new,
                        Collectors.filtering(i -> i.getAge() > 30, Collectors.toList())));
        groupAndFilter2.forEach((key, value) -> System.out.println("length: " + key + ", value: " + value));

        System.out.println("4---");
        Map<Boolean, Optional<Instructor>> maxBy = Instructors.getAllInstructors().stream()
                .collect(Collectors.groupingBy(i -> i.getName().length() == 4,
                        Collectors.maxBy(Comparator.comparing(Instructor::getAge))));
        maxBy.forEach((key, value) -> System.out.println("length: " + key + ", value: " + value));

        System.out.println("5---");
        Map<Boolean, Instructor> collectingAndThen = Instructors.getAllInstructors().stream()
                .collect(Collectors.groupingBy(i -> i.getName().length() == 4,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Instructor::getAge)), Optional::get)));
        collectingAndThen.forEach((key, value) -> System.out.println("length: " + key + ", value: " + value));

        System.out.println("6---");
        Map<Boolean, Double> average = Instructors.getAllInstructors().stream()
                .collect(Collectors.groupingBy(i -> i.getName().length() == 4,
                        Collectors.averagingInt(Instructor::getAge)));
        average.forEach((key, value) -> System.out.println("length: " + key + ", value: " + value));

        System.out.println("7---");
        Map<Boolean, IntSummaryStatistics> summarizing = Instructors.getAllInstructors().stream()
                .collect(Collectors.groupingBy(i -> i.getName().length() == 4,
                        Collectors.summarizingInt(Instructor::getAge)));
        summarizing.forEach((key, value) -> System.out.println("length: " + key + ", value: " + value));

    }
}
