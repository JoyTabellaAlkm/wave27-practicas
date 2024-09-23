package ej3.classes;

import ej3.abstracts.Animal;
import ej3.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void comerCarne(){
        System.out.println("Come carne el perro");
    }
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }
}
