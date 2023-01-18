package com.sub.learner.javanewfeatures.bankExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

public class BankAccount {

    private int id;
    private double balance;
    private String accountName;
    private Lock lock = new ReentrantLock();

    private BiFunction<Double, Double, Double> substractFunction = (a, b) -> a - b;
    private BiFunction<Double, Double, Double> addFunction = (a, b) -> a + b;

    public BankAccount(int id, double balance, String accountName) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
    }

    public boolean withdraw(double amount) throws InterruptedException {
        if (this.lock.tryLock()) {
            Thread.sleep(100);
            balance = substractFunction.apply(balance, amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) throws InterruptedException {
        if (this.lock.tryLock()) {
            Thread.sleep(100);
            balance = addFunction.apply(balance, amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount to, double amount) throws InterruptedException {

        if (withdraw(amount)) {
            System.out.println("Withrawing amount: " + amount + " from: " + getAccountName());
            if (to.deposit(amount)) {
                System.out.println("Depositing amount: " + amount + " to: " + to.getAccountName());
                return true;
            } else {
                System.out.println("Failed to acuire both locks: refunding " + amount + " to: " + getAccountName());
                while (!deposit(amount)) {
                    continue;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "BankAccount [id=" + id + ", balance=" + balance + ", accountName=" + accountName + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
