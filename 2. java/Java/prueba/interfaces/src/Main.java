import ej3.abstracts.Animal;
import ej3.classes.Gato;
import ej3.classes.Perro;
import ej3.classes.Vaca;
import ej3.interfaces.Carnivoro;
import ej3.interfaces.Herviboro;

public class Main {

    // Creo que no es necesario el if o es simplemente la sintaxis después del instanceof no sé
    private static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }
        if (animal instanceof Herviboro){
            ((Herviboro) animal).comerHierba();
        }
    }
    public static void main(String[] args) {

        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);
        System.out.println("---------------------------------");
        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();



    }
}