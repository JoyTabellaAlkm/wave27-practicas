package org.example;

import org.example.clases.Categoria;
import org.example.clases.Inscripcion;
import org.example.clases.Participante;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Crear los objestos de los circuitos
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");
List<Categoria> listaCategorias = new ArrayList<>();
listaCategorias.add(circuitoAvanzado);
listaCategorias.add(circuitoChico);
listaCategorias.add(circuitoMedio);

        //Crear los participantes
        Participante participante1 = new Participante(1, "1232540040", "Luis", "Rodriguez", 30, "319273737", "3929293292", "B+");
        Participante participante2 = new Participante(2, "1232443444", "Maria", "Venegas", 12, "3194473555", "3199293993", "O+");
        Participante participante3 = new Participante(3, "1003999939", "Pedro", "Cote", 50, "319534543", "3192929293", "B-");
        Participante participante4 = new Participante(4, "1023233332", "Paul", "Alvarez", 23, "323123232", "2332323212", "A+");
        Participante participante5 = new Participante(5, "13442343434", "Random", "Randomiun", 38, "3323123123", "2232337212", "A+");

        //HashSet para almacenar las inscripciones y verificar que no se inscriban duplicados
        HashSet<Inscripcion> inscripciones = new HashSet<>();

        inscripciones.add(new Inscripcion(1, participante1, circuitoChico));
        inscripciones.add(new Inscripcion(2, participante2, circuitoMedio));
        inscripciones.add(new Inscripcion(3, participante3, circuitoAvanzado));
        inscripciones.add(new Inscripcion(4, participante4, circuitoChico));
        //SE CREA UN RANDOM PARA QUE SE INGRESE A UNA CATEGORIA AL AZAR
        int randomIndex = (int) (Math.random() * 3);
        inscripciones.add(new Inscripcion(5, participante5, listaCategorias.get(randomIndex)));

        //No me va a dejar añadir este ya que ya esta inscrito
        System.out.println("--- INTENTO AÑADIR UN DUPLICADO ---");
        if (!inscripciones.add(new Inscripcion(5, participante1, circuitoAvanzado)))
            System.out.println("No se pudo inscribir el participante, ya que ya se encuentra inscrito.");
        System.out.println();
        System.out.println("---INSCRITOS---");
        inscripciones.stream().sorted(Comparator.comparing(Inscripcion::getNumInscripcion)).forEach(System.out::println);
        System.out.println();

        System.out.println("---INSCRITOS EN CIRCUITO CHICO---");
        inscripciones.stream().filter(i -> i.getCategoria().getNombre().equals("Circuito Chico")).forEach(System.out::println);
        System.out.println();

        System.out.println("---ELIMINAR UN PARTICIPANTE DE LA CATEGORIA CIRCUITO CHICO---");
        inscripciones.removeIf(i -> i.getNumInscripcion() == 4);
        System.out.println();

        System.out.println("---INSCRITOS EN CIRCUITO CHICO---");
        inscripciones.stream().filter(i -> i.getCategoria().getNombre().equals("Circuito Chico")).forEach(System.out::println);

        System.out.println();

        System.out.println("---MONTO TOTAL RECAUDADO CIRCUITO CHICO---");
        int recaudadoCC = inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getNombre().equals("Circuito Chico")).mapToInt(Inscripcion::getMontoAPagar).sum();
        System.out.println("El monto recaudado en el Circuito Chico es: " + recaudadoCC);

        System.out.println();

        System.out.println("---MONTO TOTAL RECAUDADO CIRCUITO MEDIO---");
        int recaudadoCM = inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getNombre().equals("Circuito Medio")).mapToInt(Inscripcion::getMontoAPagar).sum();
        System.out.println("El monto recaudado en el Circuito Medio es: " + recaudadoCM);

        System.out.println();

        System.out.println("---MONTO TOTAL RECAUDADO CIRCUITO AVANZADO---");
        int recaudadoCA = inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getNombre().equals("Circuito Avanzado")).mapToInt(Inscripcion::getMontoAPagar).sum();
        System.out.println("El monto recaudado en el Circuito Avanzado es: " + recaudadoCA);

        System.out.println();

        System.out.println("---MONTO TOTAL RECAUDADO CARRERA---");
        int recaudadoTotal = inscripciones.stream().mapToInt(Inscripcion::getMontoAPagar).sum();
        System.out.println("El monto recaudado la carrera es: " + recaudadoTotal);
    }


}
