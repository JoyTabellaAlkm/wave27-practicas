package Clases;

import Interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }
}
