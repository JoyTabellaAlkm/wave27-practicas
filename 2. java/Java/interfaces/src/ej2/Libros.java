package ej2;

public class Libros implements Impresion{

    private int cantPag;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Libros(int cantPag, String nombreAutor, String titulo, String genero){
        this.cantPag = cantPag;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public String contenido(){
        System.out.println("Libro impreso: ");
        return "Cantidad de Páginas: " + " " +
                this.cantPag + ". " +
                "Nombre del Autor: " + " " +
                this.nombreAutor + ". " +
                "Título del Libro: " + " " +
                this.titulo + ". " +
                "Género: " + " " +
                this.genero;
    }

}
