import clases.Basic;
import clases.Cobrador;
import clases.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basico = new Basic(Double.valueOf(500000), Double.valueOf(20000), Double.valueOf(40000));
        Cobrador cobrador = new Cobrador(Double.valueOf(4000), Double.valueOf(400000));
        Ejecutivo ejecutivo = new Ejecutivo(Double.valueOf(30000), Double.valueOf(3000), Double.valueOf(6000));
        System.out.println("----BASIC----");
        basico.consultarSaldo();
        basico.pagarServicios();
        basico.retirar();
        basico.consultarSaldo();
        System.out.println("----COBRADOR----");
        cobrador.consultarSaldo();
        cobrador.retirar();
        System.out.println("----EJECUTIVO-----");
        ejecutivo.transferir();
        ejecutivo.depositar();

    }
}