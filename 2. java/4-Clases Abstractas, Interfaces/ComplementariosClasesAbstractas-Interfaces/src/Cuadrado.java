public class Cuadrado extends Figura{

    private Double ladoA;
    private Double ladoB;

    @Override
    public Double area() {
        return ladoA*ladoB;
    }

    public Cuadrado(String color, double ladoA, Double ladoB) {
        super(color);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }
}
