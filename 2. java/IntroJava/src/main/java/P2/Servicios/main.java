package P2.Servicios;

import P2.Domain.Categoria;
import P2.Domain.Inscripcion;
import P2.Domain.Participante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String Args[]){


        Participante carlos = new Participante("96136179", "Carlos", "Vasquez", (short) 17,
                                                            "96136178", "96136175", "A+");

        Participante feli = new Participante("96136179", "Felipe", "C", (short) 22,
                "96136178", "96136175", "A+");

        Participante martin = new Participante("96136179", "Martin", "E", (short) 27,
                "96136178", "96136175", "A+");

        Participante julian = new Participante("96136179", "Julian", "E", (short) 27,
                "96136178", "96136175", "A+");


        GestorInscripciones.inscribirParticipante(carlos, "Circuito Chico");
        GestorInscripciones.inscribirParticipante(feli, "Circuito Medio");
        GestorInscripciones.inscribirParticipante(martin, "Circuito Avanzado");
        GestorInscripciones.inscribirParticipante(julian, "Circuito Chico");

        GestorInscripciones.listadoParticipantesConMontos();

        System.out.println();

        GestorInscripciones.listadoParticipantesPorCircuito("Circuito Chico");

        GestorInscripciones.desinscribirParticipante("Carlos", "Circuito Chico");

        GestorInscripciones.totalRecaudado("Circuito Chico");


    }
}
