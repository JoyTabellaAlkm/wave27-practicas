package Clases;

import Interfaces.IImprimible;

public class Informe implements IImprimible {
    private String texto,autor,revisor;
    private int cantidadPaginas;

    public Informe(String texto, String autor, String revisor, int cantidadPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }


    @Override
    public String imprimir() {
        return "Informe: {" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}
