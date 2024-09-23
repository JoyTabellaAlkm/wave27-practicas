package ej3.classes;

import ej3.abstracts.Animal;
import ej3.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void comerHierba(){
        System.out.println("Come hierba la vaca");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }
}
