package com.praveen.training.responsibilitypattern;

public abstract class NotesHandler {

    protected NotesHandler sucessor;

    public void setSucessor(NotesHandler sucessor) {
        this.sucessor = sucessor;
    }

    public abstract BankAccount Withdraw(BankAccount account);

}