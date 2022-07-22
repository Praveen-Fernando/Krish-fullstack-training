package com.praveen.training.responsibilitypattern;

public class Application {
    public static void main(String args[]){

        Handler1 fiveThousand=new Handler1();
        Handler2 oneThousand=new Handler2();
        Handler3 fiveHundred=new Handler3();
        Handler4 hundred=new Handler4();

        fiveThousand.setSucessor(oneThousand);
        oneThousand.setSucessor(fiveHundred);
        fiveHundred.setSucessor(hundred);

        BankAccount Nivanka = new BankAccount(809915573,10000);
        BankAccount Shane = new BankAccount(369888849,15000);
        BankAccount Kasun = new BankAccount(100036994,2000);

        System.out.println(fiveThousand.Withdraw(Nivanka));
        System.out.println("===============================================");
        System.out.println(fiveThousand.Withdraw(Shane));
        System.out.println("===============================================");
        System.out.println(fiveThousand.Withdraw(Kasun));

    }
}
