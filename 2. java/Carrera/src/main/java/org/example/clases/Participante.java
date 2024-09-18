package org.example.clases;

public class Participante {
    private int numParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String celularEmergencia;
    private String grupoSanguineo;

    public Participante() {
    }

    public Participante(int numParticipante, String dni, String nombre, String apellido, int edad, String celular, String celularEmergencia, String grupoSanguineo) {
        this.numParticipante = numParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.celularEmergencia = celularEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumParticipante() {
        return numParticipante;
    }

    public void setNumParticipante(int numParticipante) {
        this.numParticipante = numParticipante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCelularEmergencia() {
        return celularEmergencia;
    }

    public void setCelularEmergencia(String celularEmergencia) {
        this.celularEmergencia = celularEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numParticipante=" + numParticipante +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", celularEmergencia='" + celularEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
