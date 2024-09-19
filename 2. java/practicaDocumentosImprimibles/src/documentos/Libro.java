package documentos;

import interfaces.Imprimible;

public class Libro implements Imprimible {
    private int cantPags;
    private String nombreAutor;
    private String titulo;
    private Genero genero;

    public Libro() {
    }

    public Libro(int cantPags, String nombreAutor, String titulo, Genero genero) {
        this.cantPags = cantPags;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantPags() {
        return cantPags;
    }

    public void setCantPags(int cantPags) {
        this.cantPags = cantPags;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo un libro...");
    }
}
