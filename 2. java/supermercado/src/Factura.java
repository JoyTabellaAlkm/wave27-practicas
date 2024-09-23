import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Item> listaItems;
    private double totalCompra;

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }

    public Factura(int id, Cliente cliente, List<Item> listaItems, double totalCompra) {
        this.id = id;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
