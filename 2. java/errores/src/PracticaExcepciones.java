public class PracticaExcepciones {

    private int a;
    private int b;

    public PracticaExcepciones() {
        a = 0;
        b = 300;
    }

    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }

    public void calcular()
    {
        try {

            //Cuando casteamos no muestra la exception
            if (this.a == 0) {
                System.out.println("hi");
                throw new IllegalArgumentException("Se ha producido un error");
            }

            double resultado = this.b / this.a;
            System.out.println("El resultado es: " + resultado);

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        //} catch (ArithmeticException e) {
        //    System.out.println("Se ha producido un error (ArithmeticException): " + e.getMessage());
        //}

        finally {
            System.out.println("Programa finalizado");
        }
    }
}
