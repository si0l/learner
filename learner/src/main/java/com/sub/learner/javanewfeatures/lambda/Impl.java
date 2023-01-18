package com.sub.learner.javanewfeatures.lambda;

public class Impl {

    public static void main(String[] args) {

        Say sayImpl = (phrase) -> {
            return phrase;
        };
        System.out.println(sayImpl.say("hi"));

        Say sayImpl2 = (phrase) -> phrase;
        System.out.println(sayImpl2.say("hi2"));

        Concat concatImpl = (a, b) -> a + b;
        System.out.println(concatImpl.concat("hi", " friend"));
    }

}
