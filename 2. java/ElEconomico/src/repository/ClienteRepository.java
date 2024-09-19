package repository;

import models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements CRUDRepository<Cliente>{
    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente obj) {
        clientes.add(obj);
    }

    @Override
    public void delete(long id) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(c -> c.esMismoDni(id))
                .findFirst();

        cliente.ifPresent(c -> {
            clientes.remove(c);
            print();
        });
    }

    @Override
    public Optional<Cliente> searchById(long id) {
        return clientes.stream()
                .filter(c -> c.esMismoDni(id))
                .findFirst();
    }

    @Override
    public List<Cliente> searchAll() {
        return clientes;
    }

    @Override
    public void print() {
        clientes.stream()
                .forEach(System.out::println);
    }
}
