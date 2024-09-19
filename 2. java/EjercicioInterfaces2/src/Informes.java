public class Informes implements IImprimir{
    public String text;
    public int cantidadPaginas;
    public String autor;
    public String revisor;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe");
    }
}
