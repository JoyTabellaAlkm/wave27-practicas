package Ejercicio3;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static double sueldoBase = 0;
    static String dni = null;
    static double sueldoConAumento = 0;


    public static void main(String[] args) {
        System.out.println("Ingrese el dni del empleado: ");
        dni = scan.nextLine();
        System.out.println("Ingrese el sueldo base del empleado: ");
        sueldoBase = scan.nextDouble();

        if (sueldoBase<=20000) {
            sueldoConAumento = sueldoBase + (sueldoBase * 0.2);
        }
        else if (sueldoBase>20000 && sueldoBase<=45000) {
            sueldoConAumento = sueldoBase + (sueldoBase * 0.1);
        }

            else {
                sueldoConAumento = sueldoBase + (sueldoBase * 0.05);
            }
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }


    }


