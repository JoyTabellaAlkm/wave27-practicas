public class LibroPDF implements IImprimir{
    public int cantidadPaginas;
    public String autor;
    public String titulo;
    public String genero;

    @Override
    public void imprimir() {
        System.out.println("Imprimiento libro PDF");
    }
}
