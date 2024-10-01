/*
 * Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre
 * ellas se encuentran: Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo,
 * Pago de Servicios. Todas las transacciones tienen dos métodos en común,
 * que son transaccionOk() y transaccionNoOk().
 * */
public interface ITransaccion {

    public void transaccionOK();

    public void transaccionNoOK();
}
