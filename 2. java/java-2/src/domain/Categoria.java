package domain;

import exception.InvalidCategoryException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class Categoria {
    public static final String NOMBRE_CHICO = "Circuito chico";
    public static final String NOMBRE_MEDIO = "Circuito medio";
    public static final String NOMBRE_AVANZADO = "Circuito avanzado";
    private int id;
    private String nombre;
    private String descripcion;
    private List<Inscripcion> inscripciones;

    protected Categoria(int id, String nombre, String descripcion) {
        String[] nombres = new String[]{NOMBRE_CHICO, NOMBRE_MEDIO, NOMBRE_AVANZADO};
        if (Arrays.stream(nombres).noneMatch(nombre::equals)) {
            throw new InvalidCategoryException(String.format("%s no es un nombre válido.", nombre));
        }

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscripciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    protected void agregarInscripcion(Inscripcion inscripcion) {
        this.inscripciones.add(inscripcion);
    }

    protected void quitarInscripcion(Inscripcion inscripcion) {
        this.inscripciones.remove(inscripcion);
    }

    public int montoRecaudado() {
        return inscripciones.stream().mapToInt(Inscripcion::getMonto).sum();
    }

    public Stream<String> getInscripciones() {
        return inscripciones.stream().map(Inscripcion::toString);
    }

    public abstract int calcularMonto(int edadParticipante);
}
