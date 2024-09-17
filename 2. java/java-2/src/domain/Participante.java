package domain;

import exception.AlreadySubscribedException;
import exception.NotSubscribedException;

import java.util.Random;

public class Participante {
    private int numero;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroDeEmergencia;
    private String grupoSanguineo;
    private Inscripcion inscripcion;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, String celular, String numeroDeEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    protected int getEdad() {
        return edad;
    }

    public void inscribirACategoria(Categoria categoria) {
        if (inscripcion != null) {
            throw new AlreadySubscribedException("El participante ya está inscripto a una categoría.");
        }

        Inscripcion inscripcion = new Inscripcion(new Random().nextInt(0, 99999), categoria, this);
        this.inscripcion = inscripcion;
        categoria.agregarInscripcion(inscripcion);
    }

    public void desinscribir() {
        if (inscripcion == null) {
            throw new NotSubscribedException("El participante no está inscripto a ninguna categoría.");
        }

        inscripcion.cancelar();
        inscripcion = null;
    }

    @Override
    public String toString() {
        return String.format("""
                Número de participante: %d
                Nombre: %s
                Apellido: %s
                Dni: %d
                Edad: %d
                Celular: %s
                Número de emergencia: %s
                Grupo sanguíneo: %s
                """,
                numero,
                nombre,
                apellido,
                dni,
                edad,
                celular,
                numeroDeEmergencia,
                grupoSanguineo);
    }
}
