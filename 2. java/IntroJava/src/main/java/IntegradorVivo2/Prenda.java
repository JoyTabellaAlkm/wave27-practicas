package IntegradorVivo2;

public class Prenda {

    private String marca;

    private String modelo;

    public Prenda(String prenda, String modelo) {
        this.marca = prenda;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "prenda='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
