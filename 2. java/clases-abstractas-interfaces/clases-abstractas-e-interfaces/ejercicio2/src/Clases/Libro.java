package Clases;

import Interfaces.IImprimible;

public class Libro implements IImprimible {
    private int cantidadPagina;
    private String nombreAutor, titulo, genero;

    public Libro(int cantidadPagina, String nombreAutor, String titulo, String genero) {
        this.cantidadPagina = cantidadPagina;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String imprimir() {
        return "Libro{" +
                "cantidadPagina=" + cantidadPagina +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
