package Interfaces;

public interface IPagoServicio extends ITransaccion{
    final static String name = "Pago servicio";
    public void hacerPagoServicio(boolean estado);
}
