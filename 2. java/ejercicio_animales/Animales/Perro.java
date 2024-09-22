package ClasesAbstractasLandas.Ejercicio3.Animales;

import ClasesAbstractasLandas.Ejercicio3.GustosAlimenticios.Carnivoros;

public class Perro extends Animal implements Carnivoros {


    @Override
    public void emitirSonido() {
        System.out.println("Scooby dooby doo");
    }

    public void comerAnimal(){
        comerCarne();
    }

    public void comerCarne(){
        System.out.println("Comiendo carne...");
    }
}
