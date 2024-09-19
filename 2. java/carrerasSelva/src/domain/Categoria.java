package domain;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    public static final String NOMBRE_CIRCUITO_CHICO = "Circuito Chico";
    public static final String NOMBRE_CIRCUITO_MEDIO = "Circuito Medio";
    public static final String NOMBRE_CIRCUITO_AVANZADO = "Circuito Avanzado";
    private int id;
    private String nombre;
    private String descripcion;
    private List<Participante> inscriptos;

    public Categoria (int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscriptos = new ArrayList<Participante>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void listarInscriptos() {
        if (inscriptos.isEmpty()) {
            System.out.println("No hay inscriptos en la categoría " + this.nombre);
            return;
        }

        for (Participante participante : inscriptos) {
            System.out.println(participante.getNombre() + " " + participante.getApellido());
        }
    }

    public void desinscribirParticipante(int nroParticipante) {
        Participante participante = inscriptos.stream().filter(p -> p.getNro() == nroParticipante).findFirst().orElse(null);

        if (participante != null) {
            inscriptos.remove(participante);
            participante.desinscribir();
        }
    }

    public void inscribirParticipante(Participante participante) {
        inscriptos.add(participante);
    }
}
