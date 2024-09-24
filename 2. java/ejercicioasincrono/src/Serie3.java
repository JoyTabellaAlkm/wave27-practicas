public class Serie3 extends Prototipo {
    public Serie3() {
        super();
    }

    @Override
    public Integer devolverNumero() {
        return numeroProximo += 3;
    }
}
