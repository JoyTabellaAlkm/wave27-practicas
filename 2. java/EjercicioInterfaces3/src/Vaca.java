public class Vaca extends Animal implements Herviboro{
    @Override
    public String emitirSonido() {
        return "Muuuu";
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}
