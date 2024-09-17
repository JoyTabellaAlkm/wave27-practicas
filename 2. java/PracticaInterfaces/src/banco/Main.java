package banco;

import banco.clientes.Basic;
import banco.clientes.Cobrador;
import banco.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Basic basico = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        basico.consultarSaldo();
        basico.pagandoServicios();
        basico.retiroEfectivo();

        cobrador.retiroEfectivo();
        cobrador.consultarSaldo();


    }
}