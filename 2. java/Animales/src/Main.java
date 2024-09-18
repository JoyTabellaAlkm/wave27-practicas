import clases.Animal;
import clases.Gato;
import clases.Perro;
import clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal gato = new Gato();
        Animal perro = new Perro();
        Animal vaca = new Vaca();

        //HACER SONIDO
        gato.hacerSonido();
        perro.hacerSonido();
        vaca.hacerSonido();

        //COMER
        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        animal.comer();
    }


}