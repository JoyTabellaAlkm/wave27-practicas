package animales;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonidos() {
        System.out.println("MUUUU...");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo Pasto...");
    }
}
