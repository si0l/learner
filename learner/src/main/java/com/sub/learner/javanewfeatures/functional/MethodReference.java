package com.sub.learner.javanewfeatures.functional;

import java.util.function.Predicate;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class MethodReference {

    public static void main(String[] args) {
        Predicate<Instructor> p = MethodReference::checkAge;
        Instructors.getAllInstructors().forEach((instructor) -> {
            if (p.test(instructor)) {
                System.out.println(instructor);
            }
        });
    }

    private static boolean checkAge(Instructor instructor) {
        return instructor.getAge() > 30;
    }
}
