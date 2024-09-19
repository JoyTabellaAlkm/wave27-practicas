package Animales;

import interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    @Override
    public void hacerSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerAnimal() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pasto en la plaza");
    }
}
