package Imprimibles;

public class Informe implements iImprimible {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe() {
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe");
    }

    public void setTexto(String texto) {
        if (texto.length()>=200){
            System.out.println("Este texto es largo");
            this.texto = "";
            return;
        }
        this.texto = texto;
    }
}
