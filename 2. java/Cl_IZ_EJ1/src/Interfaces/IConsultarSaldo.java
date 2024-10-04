package Interfaces;

public interface IConsultarSaldo extends ITransaccion{
    final static String name = "Consultar saldo";
    public void hacerConsultaSaldo(boolean estado);
}
