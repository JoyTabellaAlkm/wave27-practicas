package org.example;

public class Report implements IPrintable{

    private int qtyPages;
    private String text;
    private String author;
    private String reviewer;

    public Report(int qtyPages, String text, String author, String reviewer) {
        this.qtyPages = qtyPages;
        this.text = text;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public void printable() {
        System.out.println("Contenido: " + text);
        System.out.println("Autor : " + author);
        System.out.println("Revisor: " + reviewer);
        System.out.println("Cantidad de paginas: " + qtyPages);
    }
}
