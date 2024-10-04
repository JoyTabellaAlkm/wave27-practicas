public class JP2_Ej2 {
    public static void main(String[] args) {
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura = 0;
        int precioSeguridadCamara = 1500;
        int patrullaje = 700;

        for (int i=0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = precioSeguridadCamara;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = precioSeguridadCamara + patrullaje;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}
