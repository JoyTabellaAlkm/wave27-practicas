package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Resume cv = new Resume("Antonella Basalo",30,new ArrayList<>());
        PdfBook libro = new PdfBook(235,"J.K Rowling","Harry Potter y la piedra Filosofal","Fantasia");
        Report informe = new Report(500,"Informe de Actividad","Antonella","Sole y Emi");

        cv.printable();
        System.out.println("------------------------------------");
        libro.printable();
        System.out.println("------------------------------------");
        informe.printable();
    }
}