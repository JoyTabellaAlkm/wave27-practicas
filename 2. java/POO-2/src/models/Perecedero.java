package models;

public class Perecedero extends Producto {
    private static final int CADUCA_EN_UN_DIA = 1;
    private static final int CADUCA_EN_DOS_DIAS = 2;
    private static final int CADUCA_EN_TRES_DIAS = 3;
    private int diasCaducar;

    public Perecedero(String nombre, double precio, int diasCaducar) {
        super(nombre, precio);
        this.diasCaducar = diasCaducar;
    }

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasCaducar=" + diasCaducar +
                "} " + super.toString();
    }

    @Override
    public double calcular(int cantidad) {
        double precio = super.calcular(cantidad);

        switch (diasCaducar) {
            case CADUCA_EN_UN_DIA:
                precio /= 4;
                break;

            case CADUCA_EN_DOS_DIAS:
                precio /= 3;
                break;

            case CADUCA_EN_TRES_DIAS:
                precio /= 2;
                break;

            default:
                break;
        }

        return precio;
    }
}
