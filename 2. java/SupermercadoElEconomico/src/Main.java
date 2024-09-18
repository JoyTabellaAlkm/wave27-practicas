import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteImp;
import repository.FacturaImp;
import repository.ItemImp;

public class Main {
    public static void main(String[] args) {
        //Instanciar las clases implementadoras del CRUD
        ClienteImp clienteImp = new ClienteImp();
        ItemImp itemImp = new ItemImp();
        FacturaImp facturaImp = new FacturaImp();

        //Instanciar nuevos clientes
        Cliente cliente1 = new Cliente(1002938233L, "Leandro", "Ramirez");
        Cliente cliente2 = new Cliente(1012928935L, "Juan", "Rivas");
        Cliente cliente3 = new Cliente(1232406885L, "Juliana", "Schroz");

        //Guardar clientes
        clienteImp.save(cliente1);
        clienteImp.save(cliente2);
        clienteImp.save(cliente3);

        //Consultar clientes
        System.out.println("---CLIENTES REGISTRADOS---");
        System.out.println(clienteImp.getAll());
        System.out.println();
        //Eliminar cliente
        clienteImp.delete(1232406885L);
        System.out.println();

        //Consultar clientes
        System.out.println("---CLIENTES REGISTRADOS---");
        System.out.println(clienteImp.getAll());
        System.out.println();

        //Editar cliente
        clienteImp.update(new Cliente(1002938233L, "Leandrox", "Ramirez"));
        System.out.println();

        //Consultar clientes
        System.out.println("---CLIENTES REGISTRADOS---");
        System.out.println(clienteImp.getAll());
        System.out.println();


        //Instanciar items
        Item item1 = new Item(1L, "Manzanas", 100, 4800.00);
        Item item2 = new Item(2L, "Pan Integral", 50, 4000.00);
        Item item3 = new Item(3L, "Leche", 75, 3200.00);
        Item item4 = new Item(4L, "Huevos", 30, 8000.00);
        Item item5 = new Item(5L, "Yogur Natural", 40, 2400.00);
        Item item6 = new Item(6L, "Pasta", 60, 6000.00);
        Item item7 = new Item(7L, "Tomates", 20, 8000.00);
        Item item8 = new Item(8L, "Pollo", 25, 20000.00);
        Item item9 = new Item(9L, "Arroz", 80, 4400.00);
        Item item10 = new Item(10L, "Jugo de Naranja", 15, 10000.00);

        //Guardar los items
        itemImp.save(item1);
        itemImp.save(item2);
        itemImp.save(item3);
        itemImp.save(item4);
        itemImp.save(item5);
        itemImp.save(item6);
        itemImp.save(item7);
        itemImp.save(item8);
        itemImp.save(item9);
        itemImp.save(item10);

        //Consultar items
        System.out.println("---ITEMS REGISTRADOS---");
        System.out.println(itemImp.getAll());
        System.out.println();

        //Eliminar item
        itemImp.delete(10L);
        System.out.println();

        //Consultar items
        System.out.println("---ITEMS REGISTRADOS---");
        System.out.println(itemImp.getAll());
        System.out.println();

        //Editar item
        itemImp.update(new Item(9L, "Arroz", 100, 4000.00));
        System.out.println();

        //Consultar items
        System.out.println("---ITEMS REGISTRADOS---");
        System.out.println(itemImp.getAll());
        System.out.println();

        //Instanciar Facturas
        Factura factura1 = new Factura(1L,clienteImp.getById(1002938233L).get(), itemImp.getAll());

        //Guardar Factura
        facturaImp.save(factura1);

        //Consultar Facturas
        System.out.println("---FACTURAS REGISTRADAS---");
        System.out.println(facturaImp.getAll());
        System.out.println();

        //Editar item para verse reflejado en la factura
        itemImp.update(new Item(9L, "Arroz", 100, 5000.00));
        System.out.println();

        //Editar factura
        facturaImp.update(new Factura(1L,clienteImp.getById(1002938233L).get(), itemImp.getAll()));
        System.out.println();

        //Consultar facturas
        System.out.println("---FACTURAS REGISTRADAS---");
        System.out.println(facturaImp.getAll());
        System.out.println();

        //Eliminar factura
        facturaImp.delete(1L);
        System.out.println();

        //Consultar facturas
        System.out.println("---FACTURAS REGISTRADAS---");
        System.out.println(facturaImp.getAll());

    }
}