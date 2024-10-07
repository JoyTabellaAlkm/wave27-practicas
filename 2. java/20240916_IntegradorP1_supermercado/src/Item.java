public class Item {
    // De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.

    private int codigo;
    private int cantidadComprada;
    private double costoUnitario;

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }

    public Item(int codigo, int cantidadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }
}
