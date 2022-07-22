package com.praveen.training.mementopattern;

import java.util.ArrayList;

public class Account {

    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addDebits(Transaction transaction){
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getDebits() {
        return (ArrayList<Transaction>) transactions.clone();
    }

    public AccountMemento save(){
        return new AccountMemento(getDebits());
    }

    public void revert(AccountMemento accountMemento){
        transactions = accountMemento.getTransaction();
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountHolder=" + transactions +
                '}';
    }

    static  class AccountMemento{

        ArrayList<Transaction> transaction;

        public AccountMemento(ArrayList<Transaction> transaction){
            this.transaction = transaction;
        }

        private ArrayList<Transaction> getTransaction(){
            return transaction;
        }
    }
}
