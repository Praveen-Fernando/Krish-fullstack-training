package com.praveen.training.responsibilitypattern;

public class Handler2 extends NotesHandler {

    @Override
    public BankAccount Withdraw(BankAccount account) {
        int requestedAmount = account.getRemainAmountTOIssueNotes();

        int numberofNotesToIssued = requestedAmount / 1000;
        if (numberofNotesToIssued > 0) {
            if (numberofNotesToIssued > 1) {
                System.out.println(numberofNotesToIssued + " Issued by Handler 2");
            } else {
                System.out.println(numberofNotesToIssued + " Issued by Handler 2");
            }
        }
        int pendingAmountToBeProcessed = requestedAmount % 1000;

        if (pendingAmountToBeProcessed > 0) {
            account.setRemainAmountTOIssueNotes(pendingAmountToBeProcessed);
            sucessor.Withdraw(account);
        }
        return account;
    }
}
