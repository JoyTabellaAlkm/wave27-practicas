public abstract class Reserva {
    private int id;
    private int precio;

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", precio=" + precio +
                '}';
    }

    public Reserva(int id, int precio) {
        this.id = id;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
