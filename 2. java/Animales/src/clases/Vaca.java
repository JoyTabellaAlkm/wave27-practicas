package clases;

import interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {

    @Override
    public void hacerSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca esta comiendo hierba.");
    }
}
