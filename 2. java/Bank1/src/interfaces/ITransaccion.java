package interfaces;

public interface ITransaccion {
    public abstract void transaccionOk(String tipoTransaccion) ;
     public abstract void transaccionNoOk(String tipoTransaccion);
}
