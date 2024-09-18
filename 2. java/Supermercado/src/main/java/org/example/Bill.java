package org.example;

import java.util.List;

public interface Bill {

    Client getClient();
    List<Item> getItems();
    void addItem(Item item);
    void removeItem(Item item);
    double calculateTotal();
}
