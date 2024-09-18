package org.example.transactions;

public class Deposit implements Transactions{
    @Override
    public boolean transactionOk() {
        return false;
    }

    @Override
    public boolean transactionNoOk() {
        return false;
    }
}
