package entity;

import java.util.Arrays;

public class Informe {
    private String[] texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String[] texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto=" + Arrays.toString(texto) +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
