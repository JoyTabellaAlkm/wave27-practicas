public class Main {
    public static void main(String[] args) {

//Ejercicio 1:

        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (20000 >= sueldoBase) {
            sueldoConAumento = sueldoBase* 1.2;
        }
        else {
            if (20000 < sueldoBase && sueldoBase <= 45000){
                sueldoConAumento = sueldoBase* 1.1;
            }
            else {
                sueldoConAumento = sueldoBase* 1.05;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);

        //Ejercicio 2:
        int serviciosCli[] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;
        double precioFijo = 1500;
        double servicioPatrulla = 700;

        for (int i = 0; i< serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = precioFijo;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = precioFijo + servicioPatrulla;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}