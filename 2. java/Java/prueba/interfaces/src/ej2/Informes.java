package ej2;

public class Informes implements Impresion{

    private String texto;
    private int cantPag;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantPag, String autor, String revisor){
        this.texto = texto;
        this.cantPag = cantPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String contenido(){
        System.out.println("Informe impreso");
        return "Texto: " + " " +
                this.texto + ". " +
                "Cantidad de Páginas: " + " " +
                this.cantPag + ". " +
                "Nombre del Autor: " + " " +
                this.autor + ". " +
                "Revisor: " + " " +
                this.revisor;
    }

}
