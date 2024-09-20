import Clases.Basic;
import Clases.Cobradores;
import Clases.Ejecutivo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Creacion de objetos
        Basic basic = new Basic();
        Cobradores cobrador = new Cobradores();
        Ejecutivo ejecutivo = new Ejecutivo();

        //realizar transaccione
        System.out.println("----------------------------------");
        System.out.println("Operaciones de cliente basico");
        basic.hacerConsultaSaldo(true);
        basic.hacerPagoServicio(false);
        basic.hacerRetiroEfectivo(true);
        System.out.println("----------------------------------");
        System.out.println("Operaciones de cliente cobrador");
        cobrador.hacerConsultaSaldo(true);
        cobrador.hacerRetiroEfectivo(false);
        System.out.println("----------------------------------");
        System.out.println("Operaciones de cliente ejecutivo");
        ejecutivo.hacerDeposito(false);
        ejecutivo.hacerTransferencia(true);
        System.out.println("----------------------------------");

    }
}