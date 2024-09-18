package org.example.transactions;

public class CashWithdrawal implements Transactions{
    @Override
    public boolean transactionOk() {
        return false;
    }

    @Override
    public boolean transactionNoOk() {
        return false;
    }
}
