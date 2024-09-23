package ej2;

public class Main {
    public static void main(String[] args) {
        SerieEntero serieDe2 = new SerieEntero(2);
        System.out.println(serieDe2.siguienteValor());
        System.out.println(serieDe2.siguienteValor());
        System.out.println(serieDe2.siguienteValor());
        System.out.println(serieDe2.siguienteValor());

        serieDe2.establecerValorInicial(1);
        System.out.println(serieDe2.siguienteValor());
        System.out.println(serieDe2.siguienteValor());
        System.out.println(serieDe2.siguienteValor());
        System.out.println(serieDe2.siguienteValor());
        System.out.println(serieDe2.siguienteValor());

        SerieDouble serieDe3Dobles = new SerieDouble(3.0);
        System.out.println(serieDe3Dobles.siguienteValor());
        System.out.println(serieDe3Dobles.siguienteValor());
        System.out.println(serieDe3Dobles.siguienteValor());
        System.out.println(serieDe3Dobles.siguienteValor());
    }
}
