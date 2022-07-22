package com.praveen.training.responsibilitypattern;

public class Handler3 extends NotesHandler {

    @Override
    public BankAccount Withdraw(BankAccount account) {
        int requestedAmount = account.getRemainAmountTOIssueNotes();

        int numberofNotesToIssued = requestedAmount / 500;
        if (numberofNotesToIssued > 0) {
            if (numberofNotesToIssued > 1) {
                System.out.println(numberofNotesToIssued + " Issued by Handler 3");
            } else {
                System.out.println(numberofNotesToIssued + " Issued by Handler 3");
            }
        }
        int pendingAmountToBeProcessed = requestedAmount % 500;

        if (pendingAmountToBeProcessed > 0) {
            account.setRemainAmountTOIssueNotes(pendingAmountToBeProcessed);
            sucessor.Withdraw(account);
        }
        return account;
    }
}

