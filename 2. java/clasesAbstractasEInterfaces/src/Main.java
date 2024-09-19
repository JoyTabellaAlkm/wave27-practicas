import clients.Basic;
import clients.Cobrador;
import clients.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Basic basico = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        basico.realizarConsultaComun();
        basico.realizarPagoServicio();
        basico.realizarConsultaComun();

        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        cobrador.realizarConsultaComun();
        cobrador.retirarEfectivo();
    }
}