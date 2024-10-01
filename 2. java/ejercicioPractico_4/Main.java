public class Main {

    public static void main(String[] args) {

        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase <= 20000) {

            sueldoConAumento = ((20*sueldoBase)/100) + sueldoBase;
        }
        else {
            if ((sueldoBase > 20000) || (sueldoBase <= 45000)){
                sueldoConAumento = ((10*sueldoBase)/100) + sueldoBase;
            }
            else {
                sueldoConAumento = ((5*sueldoBase)/100) + sueldoBase;
            }
        }
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
}