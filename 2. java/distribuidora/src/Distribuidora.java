import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Perecedero("Leche", 1.5, 2));
        productos.add(new NoPerecedero("Papel", 2.5, "Higienico"));
        productos.add(new Producto("Lapiz", 0.5));
        productos.add(new Perecedero("Yogurt", 1.0,5));
        productos.add(new NoPerecedero("Lapicera", 1.0, "Boligrafo"));
        double total=0;

        for (Producto producto : productos) {
            System.out.println(producto.toString());
            total += producto.calcular(productos.size());
            System.out.println("Precio: " + producto.calcular(productos.size())+"\n");
        }

        System.out.println("---------------------------");
        System.out.println("Total: " + total);

    }
}