import Animales.*;


public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    private static void comerAnimal(Animal animal) {
        animal.hacerSonido();
        animal.comerAnimal();
    }
}