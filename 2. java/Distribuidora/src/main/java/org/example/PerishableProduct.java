package org.example;

public class PerishableProduct extends Product {

    private int daysToExpire;

    public PerishableProduct(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Dias por caducar: " + daysToExpire;
    }

    @Override
    public double calculate(int qtyOfProducts){
        double finalPrice = super.calculate(qtyOfProducts);
        if (daysToExpire == 1){
            finalPrice /= 4;
        } else if (daysToExpire == 2){
            finalPrice /= 3;
        } else if (daysToExpire == 3) {
            finalPrice /= 2;
        }
        return finalPrice;
    }
}
