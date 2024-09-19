package transactions;

public interface ConsultaComun extends Transaction {
    void realizarConsultaComun();

    @Override
    public void transaccionOk();

    @Override
    public void transaccionNoOk();
}
