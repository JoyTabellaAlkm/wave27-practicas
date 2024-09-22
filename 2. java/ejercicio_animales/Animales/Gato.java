package ClasesAbstractasLandas.Ejercicio3.Animales;

import ClasesAbstractasLandas.Ejercicio3.GustosAlimenticios.Carnivoros;

public class Gato extends Animal implements Carnivoros {

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    public void comerAnimal(){
        comerCarne();
    }

    public void comerCarne(){
        System.out.println("Comiendo carne...");
    }
}
