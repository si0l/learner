package com.sub.learner.javanewfeatures.model;

import java.util.List;

public interface InstructorFactory {

    public abstract Instructor getInstructor(String name, int age, List<String> courses);
    
}
