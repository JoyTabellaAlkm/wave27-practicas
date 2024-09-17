package herenciaProducto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        Producto perecedero1 = new Perecedero("Leche", 1500f, 1);
        Producto perecedero2 = new Perecedero("Huevos", 2000f, 2);
        Producto perecedero3 = new Perecedero("Queso", 7500f, 3);
        Producto perecedero4 = new Perecedero("Jamon", 2500f, 4);
        Producto perecedero5 = new Perecedero("Crema", 1500f, 5);

        Producto noPerecedero1 = new NoPerecedero("Pasta", 1500f, "Comestible");
        Producto noPerecedero2 = new NoPerecedero("Arroz", 2000f, "Comestible");
        Producto noPerecedero3 = new NoPerecedero("Pan", 7500f, "Comestible");
        Producto noPerecedero4 = new NoPerecedero("Palo de Piso", 2500f, "Mantenimiento");
        Producto noPerecedero5 = new NoPerecedero("Detergente", 1500f, "Mantenimiento");


        List<Producto> productos = new ArrayList<>();
        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(perecedero4);
        productos.add(perecedero5);
        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(noPerecedero5);


        for (Producto producto: productos){
            System.out.println(producto);
            System.out.println(producto.calcular(1));
            System.out.println("\n");
        }
    }
}
