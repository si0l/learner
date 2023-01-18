package com.sub.learner.javanewfeatures.textblocks;

public class Block {

    public static void main(String[] args) {
        String b1 = """
                                Hi
                By
                        fine
                                """;

        String b2 = """
            <html>
                <body>"Hi"</body>
            </html>
                                """;

        System.out.println(b1 + b2);
    }

}
