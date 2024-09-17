package animales;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonidos() {
        System.out.println("MIAU...");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Pescado...");
    }
}
