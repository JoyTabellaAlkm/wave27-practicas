package ClasesAbstractasLandas.Ejercicio3;

import ClasesAbstractasLandas.Ejercicio3.Animales.Animal;
import ClasesAbstractasLandas.Ejercicio3.Animales.Gato;
import ClasesAbstractasLandas.Ejercicio3.Animales.Perro;
import ClasesAbstractasLandas.Ejercicio3.Animales.Vaca;

public class MainEJ3 {

    public static void main(String[] args){
        Perro perro = new Perro();

        Gato gato = new Gato();

        Vaca vaca = new Vaca();

        perro.emitirSonido();
        perro.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();

        comerAnimal(gato);
    }

    public static void comerAnimal(Animal animal){
        animal.comerAnimal();
    }

}
