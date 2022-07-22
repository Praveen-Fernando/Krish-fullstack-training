package com.praveen.training.responsibilitypattern;

public class Handler4 extends NotesHandler {
    @Override
    public BankAccount Withdraw(BankAccount account) {
        int requestedAmount = account.getRemainAmountTOIssueNotes();

        int numberofNotesToIssued = requestedAmount / 100;
        if (numberofNotesToIssued > 0) {
            if (numberofNotesToIssued > 1) {
                System.out.println(numberofNotesToIssued + " Issued by Handler");
            } else {
                System.out.println(numberofNotesToIssued + " Issued by Handler");
            }
        }
        int pendingAmountToBeProcessed = requestedAmount % 100;

        if (pendingAmountToBeProcessed > 0) {
            account.setRemainAmountTOIssueNotes(pendingAmountToBeProcessed);
            sucessor.Withdraw(account);
        }
        return account;
    }
}
