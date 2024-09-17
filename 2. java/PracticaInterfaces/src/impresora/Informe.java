package impresora;

public class Informe implements IImprimir {

    static private String texto = "Lorem Ipsum";
    static private String autor = "Matias";
    static private String revisor = "JK Rowling";

    @Override
    public void imprimir() {
        System.out.println("El texto es: " + texto + ", Escrito por: " + autor);
    }
}
