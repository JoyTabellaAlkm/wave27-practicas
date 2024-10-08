package documentos;

public class Libro implements Imprimible{
    private int cantidadPaginas;

    public Libro(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public void hacerImprecion() {
        System.out.println(cantidadPaginas);
    }
}
