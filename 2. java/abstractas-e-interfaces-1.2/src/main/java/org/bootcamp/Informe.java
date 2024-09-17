package org.bootcamp;

public class Informe implements Imprimible {
    // Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.

    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.printf(
                """
                        Texto: %s
                        Cantidad de páginas: %s
                        Autor: %s
                        Revisor: %s
                        """,
                texto,
                cantidadDePaginas,
                autor,
                revisor
        );
    }
}
