public class Main{
    public static void main(String[] args) {
        Informes informes = new Informes();
        LibroPDF libro = new LibroPDF();
        Curriculum curriculum = new Curriculum();

        IImprimible.imprimir(informes);
        IImprimible.imprimir(libro);
        IImprimible.imprimir(curriculum);
    }
}