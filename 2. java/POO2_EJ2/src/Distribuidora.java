import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private static List<Producto> productos = new ArrayList<>();

    public static void agregarProducto(){
        productos.add(new Perecedero("Producto 1", 100, 1));
        productos.add(new Perecedero("Producto 2", 200, 2));
        productos.add(new Perecedero("Producto 3", 300, 3));
        productos.add(new NoPerecedero("Producto 4", 400, "Tipo 1"));
        productos.add(new NoPerecedero("Producto 5", 500, "Tipo 2"));
        productos.add(new NoPerecedero("Producto 6", 600, "Tipo 3"));
        productos.add(new Perecedero("Producto 7", 700, 1));
        productos.add(new Perecedero("Producto 8", 800, 2));
        productos.add(new NoPerecedero("Producto 9", 900, "Tipo 4"));
        productos.add(new NoPerecedero("Producto 10", 1000, "Tipo 5"));
    }
    public static void main(String[] args) {
        agregarProducto();
        int contadorPerecederos = 0;
        int contadorNoPerecederos = 0;
        double precio = 0;

        for (Producto producto : productos) {
            if (producto instanceof Perecedero) {
                contadorPerecederos++;
            } else if (producto instanceof NoPerecedero) {
                contadorNoPerecederos++;
            }
            precio += producto.calcular(1);
        }

        if(contadorNoPerecederos == 5 && contadorPerecederos == 5){
            System.out.println("El precio total es: " + precio);
        }
    }
}