import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Distribuidora {
    public static void main(String[] args) {

        Double precioFinal = 0.0;

        Perecedero perecedero1 = new Perecedero("Leche", 1500.00, 1);
        Producto perecedero2 = new Perecedero("Crema", 3000.99, 2);
        Producto perecedero3 = new Perecedero("Queso", 200.00, 3);
        Producto perecedero4 = new Perecedero("Carne", 7999.99, 5);
        Producto perecedero5 = new Perecedero("Huevos", 1000.00, 7);

        NoPerecedero noPerecedero1 = new NoPerecedero("Arroz", 1000.00, "Comestible");
        Producto noPerecedero2 = new NoPerecedero("Pasta", 3000.00, "Comestible");
        Producto noPerecedero3 = new NoPerecedero("Detergente", 2500.00, "Limpieza");
        Producto noPerecedero4 = new NoPerecedero("Lavandina", 100.00, "Limpieza");
        Producto noPerecedero5 = new NoPerecedero("Escoba", 270.00, "Comestible");

        List<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(perecedero1);
        listaProductos.add(perecedero2);
        listaProductos.add(perecedero3);
        listaProductos.add(perecedero4);
        listaProductos.add(perecedero5);
        listaProductos.add(noPerecedero1);
        listaProductos.add(noPerecedero2);
        listaProductos.add(noPerecedero3);
        listaProductos.add(noPerecedero4);
        listaProductos.add(noPerecedero5);

        for (Producto producto: listaProductos){
            precioFinal += producto.calcular(5);
            System.out.println(producto);
            System.out.println("\n");
        }

        System.out.println("El total de vender productos es: $" + precioFinal);

    }
}
