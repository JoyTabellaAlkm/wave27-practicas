package supermercado;

import models.Cliente;
import models.Factura;
import repository.interfaces.CRUD;
import models.productos.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Supermercado {
    private List<Cliente> clientes;
    private List<Factura> facturas;
    private List<Producto> productos;

    public Supermercado() {
        clientes = new ArrayList<>();
        facturas = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public void crearCliente(String dni, String nombre, String apellido) {
        clientes.add(new Cliente(dni, nombre, apellido));
    }

    public void listarClientes() {
        clientes.stream()
                .forEach(System.out::println);
    }

    public void eliminarCliente(String dni) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(c -> c.esMismoDni(dni))
                .findFirst();

        cliente.ifPresent(c -> {
            clientes.remove(c);
            listarClientes();
        });
    }

    public Cliente buscarCliente(String dni) {
        Optional<Cliente> clienteBuscado = clientes.stream()
                .filter(cliente -> cliente.esMismoDni(dni))
                .findFirst();

        return clienteBuscado.orElse(null);
    }

    public void cargarFactura(Factura fc) {
        facturas.add(fc);
    }
}
