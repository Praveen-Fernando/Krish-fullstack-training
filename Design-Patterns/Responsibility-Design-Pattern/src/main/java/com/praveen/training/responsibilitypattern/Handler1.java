package com.praveen.training.responsibilitypattern;

public class Handler1 extends NotesHandler {

    @Override
    public BankAccount Withdraw(BankAccount account) {
        int requestedAmount=account.getRequestedAmount();

        int numberofNotesToIssued = requestedAmount / 5000;
        if (numberofNotesToIssued > 0)
        {
            if (numberofNotesToIssued > 1)
            {
                System.out.println(numberofNotesToIssued+" Issued by Handler 1");
            }
            else
            {
                System.out.println(numberofNotesToIssued+" Issued by Handler 1");
            }
        }
        int pendingAmountToBeProcessed = requestedAmount % 5000;

        if (pendingAmountToBeProcessed > 0){
            account.setRemainAmountTOIssueNotes(pendingAmountToBeProcessed);
            sucessor.Withdraw(account);
        }
        return account;
    }
}
