package Ejercicio2;

public interface IImprimir<T> {

    static <T> void imprimir(T document){
        System.out.println("Imprimiendo: " + document.toString());
    }

}
