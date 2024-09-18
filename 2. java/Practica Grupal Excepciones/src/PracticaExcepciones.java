public class PracticaExcepciones {
    private final int a = 0;
    private final int b = 300;

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    public PracticaExcepciones() {
    }

    public void division(){
        try {
            int result = this.b / this.a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            throw new ArrayIndexOutOfBoundsException("se produjo un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    @Override
    public String toString() {
        return "PracticaExcepciones{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
