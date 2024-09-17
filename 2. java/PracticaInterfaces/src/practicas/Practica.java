package practicas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;

public class Practica {

    public static void main(String[] args) {

        List<Empleado> empleados = Arrays.asList(
                new Empleado(1, "Ana", true),
                new Empleado(2, "Luis", false),
                new Empleado(3, "Marta", true),
                new Empleado(4, "Juan", false)
        );

        empleados.stream().filter(empleado -> empleado.isActivo()).forEach(System.out::println);

        List<String> nombres = Arrays.asList("Ana", "Luis", "Marta", "Juan");

        List<String> nombresMayuscula = nombres.stream().map(String::toUpperCase).toList();
        nombresMayuscula.forEach(System.out::println);

        List<Producto> productos = Arrays.asList(
                new Producto("Producto A", 15.5),
                new Producto("Producto B", 23.0),
                new Producto("Producto C", 42.75)
        );

        Double precioTotal = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
        System.out.println(precioTotal);


        List<Empresa> empresas = Arrays.asList(
                new Empresa("Empresa 1", "Madrid"),
                new Empresa("Empresa 2", "Barcelona"),
                new Empresa("Empresa 3", "Madrid"),
                new Empresa("Empresa 4", "Sevilla")
        );

        empresas.stream().sorted(Comparator.comparing(Empresa::getUbicacion)).forEach(System.out::println);

        Double precioAlto = productos.stream().mapToDouble(Producto::getPrecio).max().orElse(0.0);
        System.out.printf("Precio mas alto " + precioAlto);
    }
}
