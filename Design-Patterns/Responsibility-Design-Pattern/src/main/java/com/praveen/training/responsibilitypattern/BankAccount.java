package com.praveen.training.responsibilitypattern;

public class BankAccount {

    private int RequestedAmount;
    private int TotalAmount;
    private int AccountNumber;
    private int RemainAmountTOIssueBill;


    public BankAccount(int accountNumber,int requestedAmount) {
        RequestedAmount = requestedAmount;
        AccountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public int getRequestedAmount() {
        return RequestedAmount;
    }

    public int getTotalAmount() {
        return TotalAmount;
    }

    public int getRemainAmountTOIssueNotes() {
        return RemainAmountTOIssueBill;
    }

    public void setRemainAmountTOIssueNotes(int remainAmountTOIssueBill) {
        RemainAmountTOIssueBill = remainAmountTOIssueBill;
    }
}