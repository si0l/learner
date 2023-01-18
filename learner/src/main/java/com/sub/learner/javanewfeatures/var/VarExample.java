package com.sub.learner.javanewfeatures.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;
import com.sub.learner.javanewfeatures.model.Instructor;
import com.sub.learner.javanewfeatures.model.Instructors;

public class VarExample {

    // var can only be used for local variables
    // var s = "hi"; //compile error

    public static void main(String[] args) {

        var a = "test";
        System.out.println(a);

        var b = new HashMap<String, String>();
        System.out.println(b);

        var n = new int[] {1, 2, 3, 4};
        System.out.println(n);

        var l = new ArrayList<String>();
        System.out.println(l);

        var i = 9 / 4; // result is int
        System.out.println(i);

        var d = 9.0 / 4; // result is double
        System.out.println(d);

        var d2 = 9d / 4d; // result is double
        System.out.println(d2);

        var instructors = Instructors.getAllInstructors();
        Predicate<Instructor> checkAge = instructor -> instructor.getAge() > 30;
        instructors.forEach(instructor -> {
            if (checkAge.test(instructor)) {
                var result = instructor.getName();
                System.out.println(result);
            }
        });


    }


}
