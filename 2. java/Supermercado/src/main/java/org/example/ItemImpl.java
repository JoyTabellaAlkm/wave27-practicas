package org.example;

public class ItemImpl implements Item{

    private String id;
    private String name;
    private double costPerUnit;
    private int qty;

    public ItemImpl(String id, String name, double costPerUnit, int qty) {
        this.id = id;
        this.name = name;
        this.costPerUnit = costPerUnit;
        this.qty = qty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getQty() {
        return this.qty;
    }

    @Override
    public double getCost() {
        return this.costPerUnit;
    }

    @Override
    public double getTotalCost() {
        return this.qty * this.costPerUnit;
    }


}
