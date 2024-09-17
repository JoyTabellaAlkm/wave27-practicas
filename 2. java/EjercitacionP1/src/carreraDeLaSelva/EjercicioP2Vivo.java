package carreraDeLaSelva;

import java.util.*;

public class EjercicioP2Vivo {
    public static void main(String[] args) {

        Map<Participante, Inscripcion> inscripciones = new HashMap<>();



        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos", 1300, 1500);
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro", 2000, 2300);
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 0, 2800);


        // Circuito Chico
        Participante lionel = new Participante(1, "43452020", "Lionel", "Messi", 21, "351269000", "1100000001", "O+");
        inscripciones.put(lionel, new Inscripcion(1, circuitoChico, lionel));

        Participante sebastian = new Participante(4, "43452040", "Sebastian", "Cruz", 17, "351269000", "1100000007", "A-");
        inscripciones.put(sebastian, new Inscripcion(4, circuitoChico, sebastian));

        Participante paula = new Participante(5, "43452050", "Paula", "Gomez", 34, "351269000", "1100000009", "B+");
        inscripciones.put(paula, new Inscripcion(5, circuitoChico, paula));

        // Circuito Medio
        Participante angel = new Participante(2, "43452025", "Angel", "Di Maria", 19, "351269000", "1100000003", "A+");
        inscripciones.put(angel, new Inscripcion(2, circuitoMedio, angel));

        Participante camila = new Participante(6, "43452060", "Camila", "Rojas", 15, "351269000", "1100000011", "AB+");
        inscripciones.put(angel,new Inscripcion(6, circuitoMedio, camila));

        Participante martin = new Participante(7, "43452070", "Martin", "Perez", 14, "351269000", "1100000013", "O-");
        inscripciones.put(martin, new Inscripcion(7, circuitoMedio, martin));

        // Circuito Avanzado
        Participante maria = new Participante(3, "43452030", "Maria", "Fernandez", 25, "351269000", "1100000005", "B-");
        inscripciones.put(maria, new Inscripcion(3, circuitoAvanzado, maria));

        Participante natalia = new Participante(8, "43452080", "Natalia", "Lagos", 28, "351269000", "1100000015", "O+");
        inscripciones.put(natalia, new Inscripcion(8, circuitoAvanzado, natalia));

        Participante juan = new Participante(9, "43452090", "Juan", "Hernandez", 30, "351269000", "1100000017", "A+");
        inscripciones.put(juan, new  Inscripcion(9, circuitoAvanzado, juan));



        mostrarInscriptosPorCategoria(inscripciones, circuitoChico);
        mostrarInscriptosPorCategoria(inscripciones, circuitoMedio);
        mostrarInscriptosPorCategoria(inscripciones, circuitoAvanzado);


        desinscribirParticipante(inscripciones, juan);
        mostrarInscriptosPorCategoria(inscripciones, circuitoAvanzado);

        int totalRecaudadoChico = calcularMontoTotalCategoria(inscripciones, circuitoChico);
        int totalRecaudadoMedio = calcularMontoTotalCategoria(inscripciones, circuitoMedio);
        int totalRecaudadoAvanzado = calcularMontoTotalCategoria(inscripciones, circuitoAvanzado);

        System.out.println("El monto recaudado en " + circuitoChico.getNombre() + ": $" + totalRecaudadoChico);
        System.out.println("El monto recaudado en " + circuitoMedio.getNombre() + ": $" + totalRecaudadoMedio);
        System.out.println("El monto recaudado en " + circuitoAvanzado.getNombre() + ": $" + totalRecaudadoAvanzado);

        int totalRecaudado = totalRecaudadoChico + totalRecaudadoMedio + totalRecaudadoAvanzado;
        System.out.println("Monto total recaudado en toda la carrera: $" + totalRecaudado);

    }

    private static void mostrarInscriptosPorCategoria(Map<Participante, Inscripcion> inscripciones, Categoria categoria) {
        System.out.println("Inscriptos en " + categoria.getNombre() + ":");
        for (Map.Entry<Participante, Inscripcion> entry : inscripciones.entrySet()) {
            Inscripcion inscripcion = entry.getValue();
            if (inscripcion.getCategoria().equals(categoria)) {
                //System.out.println("- " + inscripcion.getParticipante().getNombre() + " - Numero identificatorio: " +
                //        inscripcion.getParticipante().getNumeroParticipante() );
                System.out.println(inscripcion.getParticipante().toString());
            }
        }
    }

    private static int calcularMontoTotalCategoria(Map<Participante, Inscripcion> inscripciones, Categoria categoria) {
        int total = 0;
        for (Map.Entry<Participante, Inscripcion> entry : inscripciones.entrySet()) {
            Inscripcion inscripcion = entry.getValue();
            if (inscripcion.getCategoria().equals(categoria)) {
                total += inscripcion.getMontoAbonar();
            }
        }
        return total;
    }

    private static void desinscribirParticipante(Map<Participante, Inscripcion> inscripciones, Participante participante) {
        Participante aDesinscribir = null;
        for (Map.Entry<Participante, Inscripcion> entry: inscripciones.entrySet()) {
            Inscripcion inscripcion = entry.getValue();
            if (inscripcion.getParticipante() == participante) {
                aDesinscribir = inscripcion.getParticipante();
                break;
            }
        }
        if (aDesinscribir != null) {
            inscripciones.remove(aDesinscribir);
        }
    }
}

