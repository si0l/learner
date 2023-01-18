package com.sub.learner.javanewfeatures.functional;

import java.util.Arrays;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.InstructorFactory;

public class ConstructorReference {

    public static void main(String[] args) {

        InstructorFactory iFactory = Instructor::new;
        Instructor instructor = iFactory.getInstructor("Don", 41, Arrays.asList("1", "2", "3", "4"));
        System.out.println(instructor);

    }
}
