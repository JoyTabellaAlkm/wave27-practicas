import Clientes.Basic;
import Clientes.Cobrador;
import Clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        /*Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre ellas se encuentran:
         Depósito,
         Transferencia,
         Retiro de Efectivo,
         Consulta de Saldo,
         Pago de Servicios.

         Todas las transacciones tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().

         A partir de esto existen diferentes tipos de clientes que pueden interactuar con el banco:
         Ejecutivos: Realizan Depósitos y Transferencias.
         Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
         Cobradores: Realizan retiro de efectivo y consulta de saldos.

         Implementar el escenario según corresponda para permitir a los clientes mencionados con anterioridad, el acceso a los diferentes métodos según la operación que deseen realizar.


         Notas a tener en cuenta:
         No es necesario implementar cálculos o funciones matemáticas. Los métodos pueden ser implementaciones de mensajes mediante System.out.println. Por ejemplo, al hacer un depósito, que aparezca el mensaje “Realizándose depósito”.
         Basic, Cobrador y Ejecutivos pueden ser tratados como clases.
         Transacción puede ser tratada como una Interfaz.
         Tener en cuenta que existen diferentes tipos de transacciones que implementarán esta interfaz principal.*/

        //crear un cliente de cada uno y probar los metodos
        Basic basic = new Basic();
        System.out.println("----------Cliente Basic----------");
        System.out.println("Metodos que implementa: ");
        basic.consultarSaldo();
        basic.pagarServicios();
        basic.retirarEfectivo();
        basic.transaccionNoOK();
        basic.transaccionOK();

        Cobrador cobrador = new Cobrador();
        System.out.println("----------Cliente Cobrador----------");
        System.out.println("Metodos que implementa: ");
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();
        cobrador.transaccionNoOK();
        cobrador.transaccionOK();

        Ejecutivo ejecutivo = new Ejecutivo();
        System.out.println("---------Cliente Ejecutivo--------");
        System.out.println("Metodos que implementa: ");
        ejecutivo.transaccionNoOK();
        ejecutivo.transaccionOK();
        ejecutivo.depositar();
        ejecutivo.transferir();



    }
}