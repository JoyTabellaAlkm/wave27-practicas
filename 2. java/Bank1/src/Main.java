public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDepositos();
        ejecutivo.realizarTransferencia();
        ejecutivo.transaccionNoOk("Deposito");
        ejecutivo.transaccionOk("transaccion");
    }
}