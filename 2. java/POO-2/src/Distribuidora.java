import models.NoPedecedero;
import models.Perecedero;
import models.Producto;

import java.util.ArrayList;

public class Distribuidora {
    private ArrayList<Producto> productos;

    public Distribuidora() {
        this.productos = new ArrayList<>();
        crearProductos();
    }

    private void crearProductos() {
        this.productos.add(new Perecedero("Leche", 1000, 7));
        this.productos.add(new Perecedero("Pan", 800, 3));
        this.productos.add(new Perecedero("Huevos", 7000, 5));
        this.productos.add(new Perecedero("Carne", 10000, 2));
        this.productos.add(new Perecedero("Pescado", 8000, 1));
        this.productos.add(new NoPedecedero("Papel higiénico", 4500, "Hogar"));
        this.productos.add(new NoPedecedero("Detergente", 6500, "Limpieza"));
        this.productos.add(new NoPedecedero("Cepillo de dientes", 3000, "Higiene"));
        this.productos.add(new NoPedecedero("Cereal", 2000, "Desayuno"));
        this.productos.add(new NoPedecedero("Galletas", 1500, "Snack"));
    }

    public void vender () {
        int cantPerecedero = 0;
        int cantNoPerecedero = 0;
        double precioTotal = 0;

        for (int i = 0; i < productos.size(); i++) {
            Producto productoActual = productos.get(i);

            if (productoActual instanceof Perecedero) {
                cantPerecedero++;
            } else if (productos.get(i) instanceof NoPedecedero) {
                cantNoPerecedero++;
            }

            precioTotal += productoActual.calcular(1);
        }

        if (cantPerecedero % 5 == 0) {
            mostrarPrecioTotal(precioTotal);
        } else if (cantNoPerecedero % 5 == 0) {
            mostrarPrecioTotal(precioTotal);
        }
    }

    private void mostrarPrecioTotal(double precioTotal) {
        System.out.println("El precio total es: " + precioTotal);
    }
}
