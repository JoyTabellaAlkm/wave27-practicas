package clients;

import transactions.ConsultaComun;
import transactions.RetiroDeEfectivo;

public class Cobrador implements ConsultaComun, RetiroDeEfectivo {
    @Override
    public void realizarConsultaComun() {
        System.out.println("Cobrador realiza consulta");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Cobrador retira efectivo");
    }
}
