package com.sub.learner.javanewfeatures.lambda;

import java.util.function.UnaryOperator;

public class VariableScope {

    static int s = 0;
    public static void main(String[] args) {

        int k = 0;
        // can't change local variable (effective final) but can change static
        UnaryOperator<Integer> a = (t) -> t++ + k + s++;// k++;
        //still can't modify (effective final), ok to modify static
        s = 1;
        //k = 1;

    }
}
