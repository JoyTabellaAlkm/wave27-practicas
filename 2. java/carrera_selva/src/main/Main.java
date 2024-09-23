package main;

import clases.Categoria;
import clases.Participante;
import clases.Inscripcion;
import clases.Inscripcion;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.", 1300, 1500);
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.", 2000, 2300);
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", 0, 2800);

        Participante pJuan = new Participante(1, "3563784653", "juan", "correa", 14, "5234726354", "5986749567", "B+");
        Participante pBrayan = new Participante(2, "2363784653", "brayan", "ricaurte", 18, "5734726354", "5786749567", "O+");
        Participante pNeider = new Participante(3, "9963784653", "neider", "pineda", 45, "5734726377", "5786749454", "AB-");

        List<Participante> participantes = Arrays.asList(pJuan, pBrayan, pNeider);
        int numeroParticipantes = participantes.size();

        // ------------------------------------ Empieza la logica ------------------------------------

        // Inscribimos una persona
        Logica.inscribirParticipante(pJuan, "Circuito medio");
        Logica.inscribirParticipante(pJuan, "Circuito medio");

        // Inscribimos al azar a una persona
        int numeroParticipanteRandom = random.nextInt(numeroParticipantes)+1;
        Participante participante = participantes.stream().filter(
                participanteFilter -> participanteFilter.getId()==(numeroParticipanteRandom)).findFirst().orElse(null);
        Logica.inscribirParticipanteAleatorio(participante);

        // Mostrar las inscripciones de una categoria
        Logica.mostrarInscripciones("Circuito medio");

        // Eliminar participante de una categoria
        Logica.desincribirParticipante(pJuan.getId(),"Circuito medio");

        // Mostrar monto total
        Logica.montoTotalRecaudado();


    }
}