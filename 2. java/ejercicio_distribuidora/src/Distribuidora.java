//Debemos entregar un trabajo para una distribuidora de productos, por lo que vamos a generar un programa que
// realice diferentes operaciones. Tendremos dos categorías de productos diferentes: Perecederos y No Perecederos.
//Crear una clase Producto que cuente con los siguientes atributos: String nombre y double precio,
// la misma debe definir los métodos getters y setters para sus atributos, un constructor que reciba
// todos sus atributos como parámetro y el método toString(). Crear el método calcular() al cual vamos a
//  pasarle un parámetro de tipo int llamado cantidadDeProductos; este método tiene que multiplicar el precio por la
//   cantidad de productos pasados.
//Crear la clase Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int, al igual que para el
// producto, definir setters, getters, constructor que reciba todos los atributos por parámetro y el método toString().
//  Esta clase debe heredar de Producto y sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase
//   Producto (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir el precio según los diasPorCaducar:
//Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
//Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
//Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.
//
//Crear la clase NoPerecedero, la misma va a tener un atributo llamado tipo, el mismo va a ser un String, crear setters,
// getters, constructor y método toString(); en esta clase el método calcular() va a hacer exactamente lo mismo que en la
//  clase Producto.
//
//Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos, imprimir el precio total al
// vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.


import java.text.DecimalFormat;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[5];
        productos[0] = new Producto("Lapiz", 50);
        productos[1] = new Perecedero(1, "Leche", 15);
        productos[2] = new NoPerecedero("Papel", 25, "Higienico");
        productos[3] = new Perecedero(2, "Yogurt", 10);
        productos[4] = new NoPerecedero("Lapicera", 10, "Boligrafo");

        DecimalFormat df = new DecimalFormat("#.##");
        double precioTotal = 0;

        for (Producto producto : productos) {
            System.out.println(producto);
            double totalPorProducto = producto.calcular(5);
            precioTotal += totalPorProducto;
            System.out.println("Precio de vender 5 productos de: " + producto.getNombre() + " es: $" + df.format(totalPorProducto));
        }
        System.out.println("Precio total por vender 5 productos de cada tipo: " + df.format(precioTotal));
    }
}
