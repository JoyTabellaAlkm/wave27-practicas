package Interfaces;

public interface IRetiroEfectivo extends ITransaccion{
    final static String name = "Retiro efectivo";
    public void hacerRetiroEfectivo(boolean estado);
}
