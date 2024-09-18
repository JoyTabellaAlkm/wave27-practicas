package org.example;

public class Main {
    public static void main(String[] args) {


        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int i= 1; i < serviciosCli.length; i++) {
            totalFactura = 0;

            if (serviciosCli[i] == 1) {
                totalFactura += 1500; // Servicio 1
                System.out.println("El tipo de servicio del cliente " + i + " es: Seguridad con cámaras");
            } else if (serviciosCli[i] == 2) {
                totalFactura += 1500 + 700; // Servicio 2
                System.out.println("El tipo de servicio del cliente " + i + " es: Seguridad con cámaras + patrullaje");
            }
            System.out.println("El monto de la factura del cliente " + i + " es de: $" + totalFactura);
        }

    }

}