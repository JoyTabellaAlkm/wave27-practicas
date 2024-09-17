package P2.Servicios;

import P2.Domain.Categoria;
import P2.Domain.CircuitoAvanzado;
import P2.Domain.Inscripcion;
import P2.Domain.Participante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorInscripciones {

    private static int numeroInscripciones = 1;

    private static List<Inscripcion> inscripciones = new ArrayList<>();

    private static Categoria circuitoChico = new Categoria(1 ,
            "Circuito Chico",
            2,
            Arrays.asList("selva", "arroyos"),
            1300,
            1500);

    private static Categoria circuitoMedio = new Categoria(2 ,
            "Circuito Medio",
            5,
            Arrays.asList("selva", "arroyos", "barro"),
            2000,
            2300);

    private static CircuitoAvanzado circuitoAvanzado = new CircuitoAvanzado(1 ,
            "Circuito Avanzado",
            2,
            Arrays.asList("selva", "arroyos","barro","escalada de piedra"),
            0000,
            2800);

    private static List<Categoria> categorias = Arrays.asList(circuitoChico, circuitoMedio, circuitoAvanzado);

    public static Inscripcion inscribirParticipante(Participante participante, String nombreCategoria) {

        Categoria categoria = categorias.stream().filter(
                categoriaFilter -> categoriaFilter.getNombre().equals(nombreCategoria)).findFirst().orElse(null);

        if(categoria == null){
            throw new RuntimeException();
        }

        Inscripcion inscritoCategoria = inscripciones.stream().filter(
                inscripcion -> inscripcion.getParticipante().getNombre().equals(participante.getNombre())).findFirst().orElse(null);

        if(inscritoCategoria != null){
            throw new RuntimeException();
        }

        Inscripcion inscripcion = new Inscripcion(numeroInscripciones,participante, categoria);

        numeroInscripciones++;

        inscripciones.add(inscripcion);

        return inscripcion;
    }

    public static void desinscribirParticipante(String nombreParticipante, String nombreCategoria) {
        inscripciones.removeIf(inscripcion ->
                inscripcion.getParticipante().getNombre().equals(nombreParticipante) &&
                        inscripcion.getCategoria().getNombre().equals(nombreCategoria)
        );

        listadoParticipantesConMontos();
    }

    public static void totalRecaudado(String nombreCategoria){
        System.out.println("\n" + "Total recaudado por la categoria: " + nombreCategoria + " - " + inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getNombre().equals(nombreCategoria))
                .mapToInt(Inscripcion::montoAPagar).sum());
    }

    public static void listadoParticipantesConMontos(){
        for(Inscripcion inscripcion : inscripciones){
            System.out.println("Participante: " + inscripcion.getParticipante().getNombre() + " - Monto: " + inscripcion.montoAPagar());
        }
    }

    public static void listadoParticipantesPorCircuito(String nombreCircuito){
        inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getNombre().equals(nombreCircuito))
                .forEach(inscripcion ->
                        System.out.println("Numero de Inscripción: " + inscripcion.getNumeroInscripcion() + " \n"
                                + "Participante: " + inscripcion.getParticipante().getNombre() + " \n"));
    }

}
