package repository;

import models.productos.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepository implements CRUDRepository<Item> {
    List<Item> items = new ArrayList<>();

    @Override
    public void save(Item obj) {
        this.items.add(obj);
    }

    @Override
    public void delete(long id) {
        items.removeIf(i -> i.tieneMismoId(id));
    }

    @Override
    public Optional<Item> searchById(long id) {
        return items.stream()
                .filter(i -> i.tieneMismoId(id))
                .findFirst();
    }

    @Override
    public List<Item> searchAll() {
        return items;
    }

    @Override
    public void print() {
        items.forEach(System.out::println);
    }
}
