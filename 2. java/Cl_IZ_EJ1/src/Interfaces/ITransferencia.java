package Interfaces;

public interface ITransferencia extends ITransaccion{
    final static String name = "Transferencia";
    public void hacerTransferencia(boolean estado);
}
