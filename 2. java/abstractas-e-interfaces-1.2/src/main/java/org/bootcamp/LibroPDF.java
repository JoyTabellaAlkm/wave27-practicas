package org.bootcamp;

public class LibroPDF implements Imprimible{
    // Incluyen atributos como cantidad de páginas, nombre del autor, título y género.

    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Título: %s
                Autor: %s
                Género: %s
                Cantidad de páginas: %s
                """,
                titulo,
                autor,
                genero,
                cantidadDePaginas);
    }
}
