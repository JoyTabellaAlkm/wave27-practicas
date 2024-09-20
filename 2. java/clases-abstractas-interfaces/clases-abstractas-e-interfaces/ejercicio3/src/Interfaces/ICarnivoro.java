package Interfaces;

public interface ICarnivoro {
    default void comerCarne(){
        System.out.println("Comer carne");
    }
}
