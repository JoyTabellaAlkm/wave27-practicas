import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        boolean programa = true;
        Scanner scanner = new Scanner(System.in);
        Participante participanteAInscribir;
        Map<String, Inscripcion> inscripciones = new HashMap<>();

        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10km por selva arroyos, barro y escalada en piedra");
        Categoria categoriaInscripcion = circuitoChico;


        System.out.println("Bienvenido");
        while (programa) {
            System.out.println("¿qué desea hacer?");
            System.out.println("1. Inscribir participante");
            System.out.println("2. Mostrar lista de inscritos por categoria");
            System.out.println("3. Desinscribir participante");
            System.out.println("4. Calcular monto recaudado");
            System.out.println("5. Salir");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.println("Numero de participante");
                    int numeroParticipante = scanner.nextInt();
                    System.out.println("dni: ");
                    String dni = scanner.next();
                    if (inscripciones.containsKey(dni)) {
                        System.out.println("El participante ya se encuentra inscrito a una categoria");
                        break;
                    }

                    System.out.println("Nombre:");
                    String nombre = scanner.next();
                    System.out.println("Apellido:");
                    String apellido = scanner.next();
                    System.out.println("Edad");
                    int edad = scanner.nextInt();
                    System.out.println("Celular");
                    String celular = scanner.next();
                    System.out.println("Numero de emergencia");
                    String numeroEmergencia = scanner.next();
                    System.out.println("Grupo sanguineo");
                    String grupoSanguineo = scanner.next();

                    participanteAInscribir = new Participante(numeroParticipante, dni, nombre, apellido, edad, celular, numeroEmergencia, grupoSanguineo);

                    System.out.println("A qué categoria desea inscribirlo?");
                    System.out.println("1. Circuito chico \n2. Circuito Medio\n3. Circuito Avanzado");
                    int eleccionCategoria = scanner.nextInt();
                    if (eleccionCategoria == 1) {
                        categoriaInscripcion = circuitoChico;
                    } else if (eleccionCategoria == 2) {
                        categoriaInscripcion = circuitoMedio;
                    } else if (eleccionCategoria == 3) {
                        categoriaInscripcion = circuitoAvanzado;
                    }

                    if (participanteAInscribir.getEdad() < 18 && eleccionCategoria == 3) {
                        System.out.println("No se permiten inscripciones a menores de 18 años en el circuito avanzado");
                    } else {
                        System.out.println("Numero de inscripcion:");
                        int numeroInscripcion = scanner.nextInt();
                        Inscripcion inscripcionParticipante = new Inscripcion(numeroInscripcion, categoriaInscripcion, participanteAInscribir);
                        inscripciones.put(participanteAInscribir.getDni(), inscripcionParticipante);
                    }
                    break;
                case 2:
                    System.out.println("Seleccione la categoria:");
                    System.out.println("1. Circuito chico \n2. Circuito Medio\n3. Circuito Avanzado");
                    int eleccionListarCategoria = scanner.nextInt();
                    if (eleccionListarCategoria == 1) {
                        System.out.println(circuitoChico.toString());
                    } else if (eleccionListarCategoria == 2) {
                        System.out.println(circuitoMedio.toString());
                    } else if (eleccionListarCategoria == 3) {
                        System.out.println(circuitoAvanzado.toString());
                    }
                    break;
                case 3:
                    System.out.println("Insterte el dni del participante:");
                    String dniDesinscribir = scanner.next();
                    if (inscripciones.containsKey(dniDesinscribir)) {
                        List<Participante> participanteDesinscribir = inscripciones.get(dniDesinscribir).getCategoria().participantes.stream()
                                .filter(x -> x.getDni().equals(dniDesinscribir)).toList();
                        inscripciones.get(dniDesinscribir).getCategoria().participantes.remove(participanteDesinscribir.get(0));
                        inscripciones.remove(dniDesinscribir);
                        System.out.println("Participante desinscrito");
                    } else {
                        System.out.println("El dni no corresponde a un participante inscrito");
                    }

                    break;
                case 4:
                    int recaudoCirChico = 0;
                    int recaudoCirMedio = 0;
                    int recaudoCirAvanzado = 0;
                    for (Inscripcion inscripcion : inscripciones.values()) {
                        if (inscripcion.getCategoria().equals(circuitoChico)) {
                            recaudoCirChico += inscripcion.getMontoAbonar();
                        } else if (inscripcion.getCategoria().equals(circuitoMedio)) {
                            recaudoCirMedio += inscripcion.getMontoAbonar();
                        } else if (inscripcion.getCategoria().equals(circuitoAvanzado)) {
                            recaudoCirAvanzado += inscripcion.getMontoAbonar();
                        }
                    }
                    int recaudoTotal = recaudoCirChico + recaudoCirMedio + recaudoCirAvanzado;
                    System.out.println("Monto recaudado por categoria:");
                    System.out.println("Circuito chico: " + recaudoCirChico);
                    System.out.println("Circuito Medio: " + recaudoCirMedio);
                    System.out.println("Circuito Avanzado: " + recaudoCirAvanzado);
                    System.out.println("Monto recaudado total: " + recaudoTotal);
                    break;
                case 5:
                    programa = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + eleccion);
            }
        }

    }
}