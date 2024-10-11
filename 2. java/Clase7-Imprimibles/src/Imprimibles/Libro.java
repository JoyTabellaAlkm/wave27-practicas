package Imprimibles;

public class Libro implements iImprimible {
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private String genero;

    public Libro() {}

    public Libro(String titulo, String autor, int cantidadPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo un Libro");
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", genero='" + genero + '\'' +
                '}';
    }
}
