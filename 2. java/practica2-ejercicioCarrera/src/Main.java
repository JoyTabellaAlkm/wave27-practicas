import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Inscripcion> inscripciones = new ArrayList<>();

        Categoria categoria1 = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria categoria2 = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria categoria3 = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(123, 234, "Juan", "Perez", 25, 987654321, 123456789, "A+");
        Participante participante2 = new Participante(124, 235, "Maria", "Gomez", 18, 987654322, 123456788, "B-");
        Participante participante3 = new Participante(125, 236, "Pedro", "Gonzalez", 19, 987654323, 123456787, "AB+");
        Participante participante4 = new Participante(567, 576, "Fabio", "Paez", 24, 987654321, 123456789, "A+");
        Participante participante5 = new Participante(678, 687, "Martha", "Velez", 18, 987654322, 123456788, "B-");
        Participante participante6 = new Participante(890, 809, "Felipe", "Giron", 27, 987654323, 123456787, "AB+");

        Inscripcion inscripcion1 = new Inscripcion(1, categoria1, participante1);
        Inscripcion inscripcion2 = new Inscripcion(2, categoria2, participante2);
        Inscripcion inscripcion3 = new Inscripcion(3, categoria3, participante3);
        Inscripcion inscripcion4 = new Inscripcion(4, categoria1, participante4);
        Inscripcion inscripcion5 = new Inscripcion(5, categoria2, participante5);
        Inscripcion inscripcion6 = new Inscripcion(6, categoria3, participante6);

        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);
        inscripciones.add(inscripcion4);
        inscripciones.add(inscripcion5);
        inscripciones.add(inscripcion6);

        List<Inscripcion> categoriaUnoList = inscripciones.stream().filter(i -> i.categoria.id == 1).collect(Collectors.toList());
        List<Inscripcion> categoriaDosList = inscripciones.stream().filter(i -> i.categoria.id == 2).collect(Collectors.toList());
        List<Inscripcion> categoriaTresList = inscripciones.stream().filter(i -> i.categoria.id == 3).collect(Collectors.toList());

        System.out.println("\nCategoria Uno: \n");
        categoriaUnoList.forEach(System.out::println);

        System.out.println("\nCategoria Dos: \n");
        categoriaDosList.forEach(System.out::println);

        System.out.println("\nCategoria Tres: \n");
        categoriaTresList.forEach(System.out::println);


        Participante pAux = new Participante();
        pAux.dni = 235;
        Inscripcion aux = new Inscripcion();
        aux.participante = pAux;
        categoriaDosList.remove(aux);

        System.out.println("\nDespues de eliminar: \n");
        categoriaDosList.forEach(System.out::println);

        double totalUno = categoriaUnoList.stream().mapToDouble(c -> c.montoAbono).reduce((a, b) -> a + b).orElse(0);
        double totalDos = categoriaDosList.stream().mapToDouble(c -> c.montoAbono).reduce((a, b) -> a + b).orElse(0);
        double totalTres = categoriaTresList.stream().mapToDouble(c -> c.montoAbono).reduce((a, b) -> a + b).orElse(0);

        double total = inscripciones.stream().mapToDouble(c -> c.montoAbono).reduce((a, b) -> a + b).orElse(0);

        System.out.println("\nTotal categoria Uno: \n"+totalUno+"\nTotal categoria Dos: \n"+totalDos+"\nTotal categoria Tres: \n"+totalTres+"\nTotal Categorias: "+total);

    }
}