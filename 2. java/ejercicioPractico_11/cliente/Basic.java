import ejercicioPractico_11.operacion.IConsultarSaldo;
import ejercicioPractico_11.operacion.IPagarServicio;
import ejercicioPractico_11.operacion.IRetiroDeEfectivo;

public class Basic implements IConsultarSaldo, IPagarServicio, IRetiroDeEfectivo {
    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOK() {

    }
}