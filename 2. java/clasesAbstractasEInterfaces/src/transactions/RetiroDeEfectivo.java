package transactions;

public interface RetiroDeEfectivo extends Transaction {
    void retirarEfectivo();

    @Override
    public void transaccionOk();

    @Override
    public void transaccionNoOk();
}
