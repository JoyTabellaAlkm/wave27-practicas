import clases.SerieAritmetica;
import clases.SerieGeometrica;

public class Main {
    public static void main(String[] args) {
        System.out.println("--SERIE ARITMETICA--");

        SerieAritmetica serieAritmetica = new SerieAritmetica(2);

        serieAritmetica.establecerValorInicial(0);
        serieAritmetica.siguiente();
        serieAritmetica.siguiente();
        serieAritmetica.siguiente();
        serieAritmetica.siguiente();

        System.out.println("\n--REINICIAR SERIE--");

        serieAritmetica.reiniciar();

        serieAritmetica.siguiente();
        serieAritmetica.siguiente();

        System.out.println("\n--SERIE GEOMETRICA--");
        SerieGeometrica serieGeometrica = new SerieGeometrica(1.5);
        serieGeometrica.establecerValorInicial(1.0);
        serieGeometrica.siguiente();
        serieGeometrica.siguiente();
        serieGeometrica.siguiente();
        serieGeometrica.siguiente();
        serieGeometrica.siguiente();

        System.out.println("\n--REINICIAR SERIE--");

        serieGeometrica.reiniciar();

        serieGeometrica.siguiente();
        serieGeometrica.siguiente();


    }
}