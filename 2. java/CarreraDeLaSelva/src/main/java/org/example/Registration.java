package org.example;

public class Registration {

    private int number;
    private int categoryId;
    private int participantId;
    private double amountReg;

    public Registration(int number, int categoryId, int participantId, double amountReg) {
        this.number = number;
        this.categoryId = categoryId;
        this.participantId = participantId;
        this.amountReg = amountReg;
    }

    public int getNumber() {
        return number;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public double getAmountReg() {
        return amountReg;
    }
}
