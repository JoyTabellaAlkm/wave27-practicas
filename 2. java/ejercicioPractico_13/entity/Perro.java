public class Perro extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("guau guau");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}