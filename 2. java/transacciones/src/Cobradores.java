public class Cobradores implements IRetirarEfectivo, IConsultarSaldo, ITransaccion{

    @Override
    public void consultarSaldo() {
        System.out.println("El cobrador consulta saldo");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("El cobrador retira efectivo");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
