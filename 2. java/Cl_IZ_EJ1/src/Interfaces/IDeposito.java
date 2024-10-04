package Interfaces;

public interface IDeposito extends ITransaccion{
    final static String name = "Deposito";
    public void hacerDeposito(boolean estado);
}
