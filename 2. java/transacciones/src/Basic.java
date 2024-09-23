public class Basic implements IConsultarSaldo, IPagarServicios, IRetirarEfectivo, ITransaccion{
    @Override
    public void consultarSaldo() {
        System.out.println("El basic consulta saldo");
    }

    @Override
    public void pagarServicios() {
        System.out.println("El basic paga servicios");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("El basic retira efectivo");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
