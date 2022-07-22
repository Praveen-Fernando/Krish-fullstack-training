package com.praveen.training.mementopattern;

public class Application {
    public static void main(String args[]){

        Bank bank = new Bank();
        Account account = new Account();
        account.addDebits(new Transaction("Praveen","808370112",8000));

        bank.save(account);
        System.out.println(account);

        account.addDebits(new Transaction("Praveen","808370112",10000));
        bank.save(account);
        System.out.println(account);

        account.addDebits(new Transaction("Praveen","808370112",5000));
        bank.save(account);
        System.out.println(account);

        //Revert the Debits
        bank.revert(account);
        System.out.println(account);
        bank.revert(account);
        System.out.println(account);
        bank.revert(account);
        System.out.println(account);
        bank.revert(account);
        System.out.println(account);
    }
}
