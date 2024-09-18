package clases;

import interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro esta comiendo carne.");
    }
}
