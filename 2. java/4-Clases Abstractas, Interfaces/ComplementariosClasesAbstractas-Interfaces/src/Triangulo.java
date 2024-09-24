public class Triangulo extends Figura{
    private double base;
    private double altura;

    @Override
    public Double area() {
        return this.base * this.altura;
    }

    public Triangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }
}
