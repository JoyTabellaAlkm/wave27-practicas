package repository;

import model.Cliente;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements ICRUD<Item>{
List<Item> listaItems = new ArrayList<>();
    @Override
    public void save(Item object) {
        listaItems.add(object);
    }

    @Override
    public List<Item> getAll() {
        return listaItems;
    }

    @Override
    public Optional<Item> getById(Long id) {
        Optional<Item> item = listaItems.stream().filter(i -> i.getCodigo().equals(id)).findFirst();
        if(item.isEmpty()) {
            System.out.println("Item no encontrado");
        }
        return item;
    }

    @Override
    public void update(Item object) {
        try {
            Optional<Item> itemEditar = getById(object.getCodigo());
            if(itemEditar.isPresent()) {
                itemEditar.get().setNombre(object.getNombre());
                itemEditar.get().setCantidadComprada(object.getCantidadComprada());
                itemEditar.get().setPrecioUnitario(object.getPrecioUnitario());
                System.out.println("Item editado.");
            }
        }catch(Exception e){
            System.out.println("Error al editar el item: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Optional<Item> itemBorrar = getById(id);
            if(itemBorrar.isPresent()) {
                listaItems.remove(itemBorrar.get());
                System.out.println("Item eliminado.");
            }
        }catch(Exception e){
            System.out.println("Error al eliminar el item: " + e.getMessage());
        }
    }
}
