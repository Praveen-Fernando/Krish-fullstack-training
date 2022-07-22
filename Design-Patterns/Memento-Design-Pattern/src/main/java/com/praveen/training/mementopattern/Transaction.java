package com.praveen.training.mementopattern;

public class Transaction {

    String accHolder;
    String accNumber;
    int amount;

    public Transaction(String accHolder, String accNumber, int amount) {
        this.accHolder = accHolder;
        this.accNumber = accNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accHolder='" + accHolder + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
