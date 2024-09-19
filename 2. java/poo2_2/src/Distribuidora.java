import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Distribuidora {
    public static void main(String[] args) {
        int contPerecedero = 0;
        int contNoPerecerdero = 0;
        int totalPerecederoPrecio = 0;
        int totalNoPerecederoPrecio = 0;
        List<Producto> productos = getProductos();

        System.out.println(productos);
        for(Producto producto: productos){
            if(producto instanceof Perecedero){
                contPerecedero++;
                totalPerecederoPrecio= totalPerecederoPrecio + (int) producto.getPrecio();
            }
            else{
                contNoPerecerdero++;
                totalNoPerecederoPrecio= totalNoPerecederoPrecio + (int) producto.getPrecio();
            }
            if(contPerecedero ==5 && contNoPerecerdero==5){
                System.out.println("El total de no perecedero es: "+totalNoPerecederoPrecio);
                System.out.println("El total de perecederos es: "+totalPerecederoPrecio);
            }
        }
    }

    private static List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        Producto producto1 = new Perecedero("zapatos",20000,2);
        Producto producto2 = new NoPerecedero("NoPerecedero","camisa", 30000);
        Producto producto3 = new Perecedero("computador",90000,3);
        Producto producto4 = new NoPerecedero("No perecedero","tv",90000);
        Producto producto5 = new Perecedero("cepillos",1000,3);
        Producto producto6 = new NoPerecedero("No perecedero","tv",90000);
        Producto producto7 = new Perecedero("cepillos",1000,3);
        Producto producto8 = new NoPerecedero("No perecedero","tv",90000);
        Producto producto9 = new Perecedero("cepillos",1000,3);
        Producto producto10 = new NoPerecedero("No perecedero","tv",90000);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
        return productos;
    }
}