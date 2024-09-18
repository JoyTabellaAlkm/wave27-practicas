package org.example;

public class PdfBook implements IPrintable {

    private int qtyPage;
    private String authorName;
    private String title;
    private String genres;

    public PdfBook(int qtyPage, String authorName, String title, String genres) {
        this.qtyPage = qtyPage;
        this.authorName = authorName;
        this.title = title;
        this.genres = genres;
    }


    @Override
    public void printable() {
        System.out.println("Titulo: " + title);
        System.out.println("Autor : " + authorName);
        System.out.println("Genero: " + genres);
        System.out.println("Cantidad de paginas: " + qtyPage);
    }
}
