import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche", 3100.0, 2));
        productos.add(new Perecedero("Queso", 5000.0, 3));
        productos.add(new Perecedero("Quesocrema", 9000.0, 1));
        productos.add(new NoPerecedero("Escoba", 1000, "Limpieza"));
        productos.add(new NoPerecedero("Trapeador", 1000, "Limpieza"));
        productos.add(new NoPerecedero("Arroz", 3250, "Alimento"));

        for (Producto producto: productos) {
            System.out.println(producto.toString());
            System.out.println("Cantidad: 5");
            System.out.println("Precio total: $" + producto.calcular(5));
            System.out.println("=====================================================");
        }
    }
}