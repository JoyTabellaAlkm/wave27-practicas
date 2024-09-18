package org.example;

public class CategoryCost {
    private double amountUnder18;
    private double amountOver18;

    public CategoryCost(double amountUnder18, double amountOver18) {
        this.amountUnder18 = amountUnder18;
        this.amountOver18 = amountOver18;
    }

    public double getAmountUnder18() {
        return amountUnder18;
    }

    public void setAmountUnder18(double amountUnder18) {
        this.amountUnder18 = amountUnder18;
    }

    public double getAmountOver18() {
        return amountOver18;
    }

    public void setAmountOver18(double amountOver18) {
        this.amountOver18 = amountOver18;
    }
}
