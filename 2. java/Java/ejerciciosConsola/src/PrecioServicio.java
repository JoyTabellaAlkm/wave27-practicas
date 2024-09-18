public class PrecioServicio {
    public static void main(String[] args) {

        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase <= 20000) {
            sueldoConAumento = ((sueldoBase * 20) / 100) + sueldoBase;
        } else {
            if (sueldoBase > 20000 && sueldoBase <= 45000) {
                sueldoConAumento = ((sueldoBase * 10) / 100) + sueldoBase;
            } else {
                sueldoConAumento = ((sueldoBase * 5) / 100) + sueldoBase;
            }
        }

        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);

    }
}
