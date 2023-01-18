package com.sub.learner.javanewfeatures.collectors;

import java.util.stream.Collectors;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class SumAverage {
    
    public static void main(String[] args) {
        
        int sum = Instructors.getAllInstructors().stream().collect(Collectors.summingInt(Instructor::getAge));
        System.out.println(sum);

        double average = Instructors.getAllInstructors().stream().collect(Collectors.averagingInt(Instructor::getAge));
        System.out.println(average);

    }
}
