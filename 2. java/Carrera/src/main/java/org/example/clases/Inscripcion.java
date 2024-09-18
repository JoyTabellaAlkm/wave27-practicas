package org.example.clases;

import java.util.HashSet;
import java.util.Objects;

public class Inscripcion {
    private int numInscripcion;
    private Participante participante;
    private Categoria categoria;
    private int montoAPagar;

    public Inscripcion() {
    }

    public Inscripcion(int numInscripcion, Participante participante, Categoria categoria) {
        this.numInscripcion = numInscripcion;
        this.participante = participante;
        this.categoria = categoria;
       this.montoAPagar= calcularMonto();
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public void setNumInscripcion(int numInscripcion) {
        this.numInscripcion = numInscripcion;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(int montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numInscripcion=" + numInscripcion +
                ", participante=" + participante +
                ", categoria=" + categoria +
                ", montoAPagar=" + montoAPagar +
                '}';
    }

    //SE MODIFICAN LOS METODOS EQUALS Y HASHCODE PARA QUE
    // SOLO VERIFIQUEN EL PARTICIPANTE, ASI NO PERMITE DUPLICADOS EN EL HASHSET
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscripcion that = (Inscripcion) o;
        return Objects.equals(participante, that.participante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participante);
    }

    public int calcularMonto () throws IllegalArgumentException{
        switch (categoria.getId()) {
            case 1:
                if (participante.getEdad() >= 18) {
                    return 1500;
                }else{
                    return 1300;
                }

            case 2:
                if (participante.getEdad() >= 18) {
                    return 2300;
                }else{
                    return 2000;
                }

            case 3:
                if (participante.getEdad() >= 18) {
                    return 2800;
                }else{
                    throw new IllegalArgumentException("Los menores de edad no pueden inscribirse en la categoría 3.");
                }


            default:
                throw new IllegalArgumentException("Categoría no válida.");
        }
    }
}
