package com.sub.learner.javanewfeatures.lambda;

public class RunableImpl {
    public static void main(String[] args) {
        Runnable runImpl = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                System.out.println("Impl1:" + sum);
            }
        };

        new Thread(runImpl).start();

        Runnable runImplL = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("Impl2:" + sum);
        };

        new Thread(runImplL).start();

        new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("Impl3:" + sum);
        }).start();

    }
}
