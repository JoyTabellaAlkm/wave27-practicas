package org.bootcamp.animales;

import org.bootcamp.preferenciasAlimenticias.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        comerHierbas();
    }

    @Override
    public void comerHierbas() {
        System.out.println("La vaca está comiendo hierbas");
    }
}
