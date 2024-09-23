import java.util.ArrayList;
import java.util.List;

public class Administrador{

    List<Cliente> listaCliente = new ArrayList<Cliente>();
    List<Factura> listaFactura = new ArrayList<Factura>();
    List<Item> listaItems = new ArrayList<Item>();

    public void addCliente(Cliente cliente){
        listaCliente.add(cliente);
    }
    public void addFactura(Factura factura){
        listaFactura.add(factura);
    }
    public void addItems(Item item){
        listaItems.add(item);
    }

    public void showClienteEspecifico(int dni){
        Cliente cliente = listaCliente.stream().filter(p->p.getDni() == dni).findFirst().orElse(null);
        if(cliente != null){
            System.out.println(cliente);
        }else{
            System.out.println("No existe el cliente con dni: "+dni);
        }
    }

    public void deleteCliente(Cliente cliente){
        listaCliente.remove(cliente);
    }
    public void deleteFactura(Factura factura){
        listaFactura.remove(factura);
    }
    public void deleteItems(Item item){
        listaItems.remove(item);
    }

    public void showCliente(){
        listaCliente.forEach(System.out::println);
        System.out.println("\n");
    }
    public void showFactura(){
        listaFactura.forEach(System.out::println);
        System.out.println("\n");
    }
    public void showItems(){
        listaItems.forEach(System.out::println);
        System.out.println("\n");
    }


}
