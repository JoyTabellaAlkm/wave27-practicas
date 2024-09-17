package animales;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonidos() {
        System.out.println("GUAU...");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo un bife...");
    }
}
