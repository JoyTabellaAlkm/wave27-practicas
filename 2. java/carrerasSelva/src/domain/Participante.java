package domain;

import exception.AlreadySubscribedException;
import exception.NotSuscribedException;

public class Participante {
    private int nro;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String nroEmergencia;
    private String grupoSanguineo;
    private Inscripcion inscripcion;

    public Participante(int nro, String dni, String nombre, String apellido, int edad, String celular, String nroEmergencia, String grupoSanguineo) {
        this.nro = nro;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
    public int getNro() {
        return this.nro;
    }
    public int getEdad() {
        return this.edad;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }

    private boolean estaInscripto() {
        return this.inscripcion != null;
    }

    public void inscribir(int nroInscripcion, Categoria categoria) {
        if (estaInscripto()) {
            throw new AlreadySubscribedException("El participante ya está inscripto");
        }

        this.inscripcion = new Inscripcion(nroInscripcion, categoria, this);
    }

    public void desinscribir() {
        if (!estaInscripto()) {
            throw new NotSuscribedException("El participante no está inscripto en ninguna categoría");
        }

        this.inscripcion.desinscribir();
        this.inscripcion = null;
    }
}
