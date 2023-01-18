package com.sub.learner.javanewfeatures.bankExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankTransfer {

    public static void main(String[] args) {

        AccountFactory aFactory = BankAccount::new;

        BankAccount a1 = aFactory.getBankAccount(1, 100, "acc1");
        BankAccount a2 = aFactory.getBankAccount(2, 200, "acc2");

        BiPredicate<Double, Double> checkBalance = (balance, amount) -> balance > amount;
        BiConsumer<String, Double> amountPrinter = (x, y) -> System.out.println(x + y);
        BiConsumer<BankAccount, BankAccount> balancePrinter = (acc1, acc2) -> {
            System.out.println("Ending balance of acc1: " + acc1.getBalance() +
                    ", ending balance of acc2: " + acc2.getBalance());
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " executing transfer");
            try {
                double amount = 15;
                if (!checkBalance.test(a1.getBalance(), amount)) {
                    amountPrinter.accept("Thread: " + Thread.currentThread().getName() + ", insufficient balance to withdraw amount: ", amount);
                    return;
                }
                while (!a1.transfer(a2, amount)) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    if (!checkBalance.test(a1.getBalance(), amount)) {
                        amountPrinter.accept("Thread: " + Thread.currentThread().getName() + ", insufficient balance to withdraw amount: ", amount);
                        return;
                    }
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amountPrinter.accept("Thread " + Thread.currentThread().getName()
                    + " successfully executed transfer, final balance is: ", a2.getBalance());
        });

        for (int i = 0; i < 20; i++) {
            executorService.submit(t1);
        }
        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(24L, TimeUnit.HOURS)) {
                System.out.println("Waiting for termination");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        balancePrinter.accept(a1, a2);
    }
}
