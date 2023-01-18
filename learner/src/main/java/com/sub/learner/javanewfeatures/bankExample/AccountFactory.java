package com.sub.learner.javanewfeatures.bankExample;

public interface AccountFactory {

    public abstract BankAccount getBankAccount(int id, double balance, String accountName);
}