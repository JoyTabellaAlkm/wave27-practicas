package org.example.transactions;

public class BillPayment implements Transactions{
    @Override
    public boolean transactionOk() {
        return false;
    }

    @Override
    public boolean transactionNoOk() {
        return false;
    }
}
