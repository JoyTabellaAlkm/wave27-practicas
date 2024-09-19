package transactions;

public interface Transferencia extends Transaction {
    void realizarTransferencia();

    @Override
    public void transaccionOk();

    @Override
    public void transaccionNoOk();
}
