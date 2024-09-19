package ClasesAbstractasLandas.Ejercicio3.Animales;

import ClasesAbstractasLandas.Ejercicio3.GustosAlimenticios.Hervivoros;

public class Vaca extends Animal implements Hervivoros {


    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    public void comerAnimal(){
        comerHierba();
    }

    public void comerHierba(){
        System.out.println("Yo solo como pasto");
    }
}
