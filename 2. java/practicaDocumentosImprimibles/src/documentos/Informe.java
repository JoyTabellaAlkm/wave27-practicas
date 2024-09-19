package documentos;

import interfaces.Imprimible;
import personas.Autor;
import personas.Revisor;

public class Informe implements Imprimible {
    private final int MAX_CARACTERES = 200;
    private String texto;
    private int cantPags;
    private Autor autor;
    private Revisor revisor;

    public Informe() {
    }

    public Informe(String texto, int cantPags, Autor autor, Revisor revisor) {
        setTexto(texto);
        this.cantPags = cantPags;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {

        if (texto.length() > MAX_CARACTERES) {
            System.out.println("Los textos admitidos deben tener menos de " + MAX_CARACTERES);
            this.texto = "";
            return;
        }

        this.texto = texto;
    }

    public int getCantPags() {
        return cantPags;
    }

    public void setCantPags(int cantPags) {
        this.cantPags = cantPags;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public void imprimir() {
        System.out.println("Imprimiendo un informe...");
    }
}
