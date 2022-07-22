package com.praveen.training.mementopattern;

import java.util.Stack;

public class Bank {
    Stack<Account.AccountMemento> history = new Stack<>();

    public void save(Account account){
        history.push(account.save());
    }

    public void revert(Account account){
        if (!history.isEmpty()){
            account.revert(history.pop());
        }else{
            System.out.println("Can't Undo the Transaction");
        }
    }
}
