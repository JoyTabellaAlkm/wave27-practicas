package ej2;

public interface Impresion {
    String contenido();

    static void imprimirContenido(Impresion documento){
        System.out.println(documento.contenido());
    };
}
