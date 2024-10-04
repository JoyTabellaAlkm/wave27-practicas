import Clases.Gato;
import Clases.Perro;
import Clases.Vaca;
import Clases.Animal;
import Interfaces.IHerviboro;
import Interfaces.ICarnivoro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void comerAnimal(Animal animal) { //Funcion que permite llamar al metodo comer de cada animal de acuerdo a la implementacion de su interfaz
        if (animal instanceof ICarnivoro) {
            ((ICarnivoro) animal).comerCarne();
        } else if (animal instanceof IHerviboro) {
            ((IHerviboro) animal).comerHierba();
        } else {
            System.out.println("Este animal no tiene un método de comida específico.");
        }
    }
    public static void main(String[] args) {
        //Crear animales
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        //Emitir sonido
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();
        //Comer
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);

    }
}