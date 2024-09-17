package org.bootcamp;

import org.bootcamp.series.SerieBigDecimal;
import org.bootcamp.series.SerieInteger;
import org.bootcamp.series.SerieNumerica;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        SerieNumerica<Integer> serie2En2 = new SerieInteger( 2);
        System.out.println("Serie 2 en 2 (integer):");
        probarSerie(serie2En2);
        System.out.println();

        SerieNumerica<BigDecimal> serie3En3 = new SerieBigDecimal(new BigDecimal(1), new BigDecimal(2));
        System.out.println("Serie desde 1 (big decimal):");
        probarSerie(serie3En3);
        System.out.println();

        SerieNumerica<Integer> serieDesde1 = new SerieInteger( 3);
        System.out.println("Serie desde 1 (integer):");
        probarSerie(serieDesde1);
        System.out.println();
    }

    private static void probarSerie(SerieNumerica<?> serie) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("1.%d: %s\n", i, serie.proximoNumero());
        }

        System.out.println("Reiniciando serie");
        serie.reiniciar();

        for (int i = 0; i < 10; i++) {
            System.out.printf("2.%d: %s\n", i, serie.proximoNumero());
        }
    }
}