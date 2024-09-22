package entity;

public class Libro {
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public Libro(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
