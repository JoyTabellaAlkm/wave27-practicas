package transactions;

public interface Deposito extends Transaction {
    void realizarDeposito();
    @Override
    public void transaccionOk();

    @Override
    public void transaccionNoOk();
}
