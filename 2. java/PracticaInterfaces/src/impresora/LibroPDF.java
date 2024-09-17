package impresora;

public class LibroPDF implements IImprimir {
    private Integer paginas;
    private String autor;
    private String genero;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Libros...");
    }
}
