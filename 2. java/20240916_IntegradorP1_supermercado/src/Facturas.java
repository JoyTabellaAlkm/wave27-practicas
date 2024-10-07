import java.util.List;

public class Facturas {
    // facturas que se generan cuando un cliente hace
    // una compra contienen a un cliente, una lista de ítems
    // y el total de la compra.

    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    @Override
    public String toString() {
        return "Facturas{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }

    public Facturas(Cliente cliente, List<Item> items, double totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }
}
