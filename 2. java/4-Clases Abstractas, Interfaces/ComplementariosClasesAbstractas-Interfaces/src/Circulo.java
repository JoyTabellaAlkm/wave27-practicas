public class Circulo extends Figura {
    private Double radio;

    @Override
    public Double area() {
        return (Math.PI)*Math.pow(radio,2);
    }

    public Circulo(String color,Double radio) {
        super(color);
        this.radio = radio;
    }
}
