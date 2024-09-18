package org.example;

import java.util.ArrayList;
import java.util.List;

public class BillImpl implements Bill {

    private final Client client;
    private final List<Item> items;


    public BillImpl(Client client, List<Item> items) {
        this.client = client;
        this.items = items;
    }

    public BillImpl(Client client) {
        this.client = client;
        this.items = new ArrayList<>();
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public List<Item> getItems() {
        return this.items;
    }

    @Override
    public void addItem(Item item) {
        this.items.add(item);

    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(Item::getTotalCost)
                .sum();
    }
}
