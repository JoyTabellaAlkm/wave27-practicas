package Ejercicio4;

public class Main {
    static int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
    static double totalFactura =0;
    public static void main(String[] args) {


        for (int i = 0; i< serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = 1500;
                System.out.println ("El tipo de servicio es: Seguridad con cámaras " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = 1500 + 700;
                System.out.println ("El tipo de servicio es: Seguridad con cámaras + patrullaje " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}
