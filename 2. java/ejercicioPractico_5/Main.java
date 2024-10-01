public class Main {
    public static void main(String[] args) {
        /*
        * Una empresa de servicios de seguridad tiene 7 clientes que todos los meses abonan la cuota de dos posibles tipos de servicio:

            Servicio 1: Seguridad con cámaras - Precio Fijo de $1500 al mes

            Servicio 2: Seguridad con cámaras + patrullaje - Precio de $1500 + $700 por el servicio de patrullaje

            Dependiendo del tipo de servicio, se desea poder calcular el monto final de la factura para cada uno de
            los clientes. Tener en cuenta, que existe un vector en donde se almacena el tipo de servicio que cada cliente adquirió.
        * */

        int[] serviciosCli = new int[7];
        //vector de 7 posiciones con tipos de servicios {1, 1, 2, 2, 2, 1, 2};

        serviciosCli[0] = 1;
        serviciosCli[1] = 1;
        serviciosCli[2] = 2;
        serviciosCli[3] = 2;
        serviciosCli[4] = 2;
        serviciosCli[5] = 1;
        serviciosCli[6] = 2;

        double totalFactura = 0;

        for (int i = 0; i <= serviciosCli.length; i++) {
            totalFactura = 1500;
            if (serviciosCli[i] == 1) {
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = totalFactura + 700;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}