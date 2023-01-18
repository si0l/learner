package com.sub.learner.javanewfeatures.switchexpression;

public class SwitchExpressionExample {

    public static void main(String[] args) {
        
        String month = "J";
        String quater = switch (month) {
            case "J", "F" -> "Q1";
            case "S" -> "Q2";
            default -> "unknown";
        };
        System.out.println(quater);

        switch(month){
            case "J", "F" -> System.out.println("Q1 month");
            case "S" -> System.out.println("Q2 month");
            default -> System.out.println("unknown");
        }

        String quater1 = switch (month) {
            case "J", "F" -> {
                yield "test";
            }
            case "S" -> "Q2";
            default -> "unknown";
        };
        System.out.println(quater1);

    }

}
