package repository;

import model.Cliente;
import model.Factura;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements ICRUD<Factura>{
    List<Factura> listaFacturas = new ArrayList<>();
    @Override
    public void save(Factura object) {
        listaFacturas.add(object);
    }

    @Override
    public List<Factura> getAll() {
      return listaFacturas;
    }

    @Override
    public Optional<Factura> getById(Long id) {
        Optional<Factura> factura = listaFacturas.stream().filter(i -> i.getIdFactura().equals(id)).findFirst();
        if(factura.isEmpty()) {
            System.out.println("Factura no encontrado");
        }
        return factura;
    }

    @Override
    public void update(Factura object) {
        try {
            Optional<Factura> facturaEditar = getById(object.getIdFactura());
            if(facturaEditar.isPresent()) {
                facturaEditar.get().setCliente(object.getCliente());
                facturaEditar.get().setListaItems(object.getListaItems());
                facturaEditar.get().setTotal(object.calcularTotal());
                System.out.println("Factura editada.");
            }
        }catch(Exception e){
            System.out.println("Error al editar la factura: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Optional<Factura> facturaBorrar = getById(id);
            if(facturaBorrar.isPresent()) {
                listaFacturas.remove(facturaBorrar.get());
                System.out.println("Factura eliminada.");
            }
        }catch(Exception e){
            System.out.println("Error al eliminar la factura: " + e.getMessage());
        }
    }

}
