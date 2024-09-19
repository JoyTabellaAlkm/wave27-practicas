package transactions;

public interface PagoDeServicio extends Transaction {
    void realizarPagoServicio();
    @Override
    public void transaccionOk();

    @Override
    public void transaccionNoOk();
}
