package repository;

import model.Cliente;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements ICRUD<Cliente>{
    List<Cliente> listaClientes = new ArrayList<>();
    @Override
    public void save(Cliente object) {
        listaClientes.add(object);
    }

    @Override
    public List<Cliente> getAll() {
       return listaClientes;
    }

    @Override
    public Optional<Cliente> getById(Long id){
        Optional<Cliente> cliente = listaClientes.stream().filter(c -> c.getDni().equals(id)).findFirst();
        if(cliente.isEmpty()) {
            System.out.println("Cliente no encontrado");
        }
        return cliente;
    }

    @Override
    public void update(Cliente object) {
        try {
            Optional<Cliente> clienteEditar = getById(object.getDni());
            if(clienteEditar.isPresent()) {
                clienteEditar.get().setNombre(object.getNombre());
                clienteEditar.get().setApellido(object.getApellido());
                System.out.println("Cliente editado.");
            }
        }catch(Exception e){
            System.out.println("Error al editar el cliente: " + e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        try {
            Optional<Cliente> clienteBorrar = getById(id);
            if(clienteBorrar.isPresent()) {
                listaClientes.remove(clienteBorrar.get());
                System.out.println("Cliente eliminado.");
            }
        }catch(Exception e){
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }
}
