package clients;

import transactions.ConsultaComun;
import transactions.PagoDeServicio;
import transactions.RetiroDeEfectivo;

public class Basic implements ConsultaComun, PagoDeServicio, RetiroDeEfectivo {
    @Override
    public void realizarConsultaComun() {
        System.out.println("Basic realiza consulta común");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizarPagoServicio() {
        System.out.println("Basic paga servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Basic retira efectivo");
    }
}
