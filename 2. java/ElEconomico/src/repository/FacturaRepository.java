package repository;

import models.Cliente;
import models.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaRepository implements CRUDRepository<Factura> {
    List<Factura> facturas = new ArrayList<>();

    @Override
    public void save(Factura obj) {
        facturas.add(obj);
    }

    @Override
    public void delete(long id) {
        Optional<Factura> factura = facturas.stream()
                .filter(c -> c.esMismoCodigo(id))
                .findFirst();

        factura.ifPresent(c -> {
            facturas.remove(c);
            System.out.println(c);
        });
    }

    @Override
    public Optional<Factura> searchById(long id) {
        return facturas.stream()
                .filter(f -> f.esMismoCodigo(id))
                .findFirst();
    }

    @Override
    public List<Factura> searchAll() {
        return facturas;
    }

    @Override
    public void print() {
        facturas.stream().forEach(System.out::println);
    }
}
