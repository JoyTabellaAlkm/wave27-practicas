import domain.*;
import exception.InvalidParticipantException;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Java2 {
    public static void main(String[] args) {
        Categoria categoriaCircuitoChico = new CircuitoChico(1);
        Categoria categoriaCircuitoMedio = new CircuitoMedio(2);
        Categoria categoriaCircuitoAvanzado = new CircuitoAvanzado(3);

        List<Categoria> categorias = List.of(categoriaCircuitoChico, categoriaCircuitoMedio, categoriaCircuitoAvanzado);
        
        Participante participante1 = crearParticipante();
        participante1.inscribirACategoria(categoriaCircuitoChico);

        Participante participante2 = crearParticipante();
        participante2.inscribirACategoria(categoriaCircuitoMedio);

        try {
            Participante participante3 = crearParticipante();
            participante3.inscribirACategoria(categoriaCircuitoAvanzado);
        } catch (InvalidParticipantException ex) {
            System.out.println(ex.getMessage());
        }

        participante1.desinscribir();
        Participante participante4 = crearParticipante();
        participante4.inscribirACategoria(categoriaCircuitoChico);

        System.out.println("//// Montos recaudados ////");
        for (Categoria categoria : categorias) {
            System.out.printf("Monto recaudado por la categoría %s: $%d%n", categoria.getNombre(), categoria.montoRecaudado());
        }

        System.out.println("//// Inscripciones ////");
        for (Categoria categoria : categorias) {
            System.out.printf("Inscriptos a la categoría %s: \n%n", categoria.getNombre());
            categoria.getInscripciones().forEach(System.out::println);
        }
    }

    private static Participante crearParticipante() {
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Ingrese el nombre:");
        String nombre = keyboard.nextLine();
        System.out.printf("Hola %s. Ingrese su apellido: %n", nombre);
        String apellido = keyboard.nextLine();
        System.out.println("DNI:");
        int dni = keyboard.nextInt();
        System.out.println("Edad: ");
        int edad = keyboard.nextInt();

        return new Participante(random.nextInt(0, 99999),
                dni, nombre, apellido, edad,
                String.valueOf(random.nextInt(11_1111_1111, 11_9999_9999)),
                String.valueOf(random.nextInt(11_1111_1111, 11_9999_9999)),
                "B+");
    }
}
