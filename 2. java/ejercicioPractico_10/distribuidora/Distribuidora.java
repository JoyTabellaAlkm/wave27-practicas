import java.util.ArrayList;
import java.util.List;

/*
 *Crear una clase ejecutable llamada Distribuidora
 * donde van a crear un array de productos,
 *  imprimir el precio total al vender 5 productos de cada tipo.
 * Crear los elementos del array con los datos que quieras
 * */

public class Distribuidora {

    public static void main(String[] args) {
        Perecedero prodPerecedero = new Perecedero("Leche", 1520.5,1);
        Perecedero prodPerecedero2 = new Perecedero("Crema", 3520.5,2);
        Perecedero prodPerecedero3 = new Perecedero("Queso", 9800.7,3);
        Perecedero prodPerecedero4 = new Perecedero("Huevo", 4700.5,1);
        Perecedero prodPerecedero5 = new Perecedero("Carne", 9000.3,2);

        NoPerecedero prodNoPerecedero = new NoPerecedero("Arroz", 2600.1,"Cereales");
        NoPerecedero prodNoPerecedero2 = new NoPerecedero("Nuez", 3600.1,"Fruto seco");
        NoPerecedero prodNoPerecedero3 = new NoPerecedero("Miel", 6600.1,"Cereales");
        NoPerecedero prodNoPerecedero4 = new NoPerecedero("Aceite", 9600.1,"Graso");
        NoPerecedero prodNoPerecedero5 = new NoPerecedero("Maiz", 2600.1,"Cereales");

        List<Producto> productos = new ArrayList<>();
        productos.add(prodPerecedero);
        productos.add(prodPerecedero2);
        productos.add(prodPerecedero3);
        productos.add(prodPerecedero4);
        productos.add(prodPerecedero5);

        productos.add(prodNoPerecedero);
        productos.add(prodNoPerecedero2);
        productos.add(prodNoPerecedero3);
        productos.add(prodNoPerecedero4);
        productos.add(prodNoPerecedero5);

        double recaudacionPerecedero = 0;
        double recaudacionNoPerecedero = 0;

        for (Producto prod : productos) {
            if(prod instanceof Perecedero){
                recaudacionPerecedero += prod.calcular((int)prod.getPrecio());
            }

            if(prod instanceof NoPerecedero) {
                recaudacionNoPerecedero += prod.calcular((int)prod.getPrecio());
            }

            System.out.println("<---------------------------------------------->");
            System.out.println(prod.toString());
            System.out.println("<---------------------------------------------->");
        }

        System.out.println("Se recaudo un total de $ "+ recaudacionPerecedero + "\nEn 5 productos perecederos");
        System.out.println("Se recaudo un total de $ " + recaudacionNoPerecedero + "\nEn 5 productos no perecederos");
    }
}
