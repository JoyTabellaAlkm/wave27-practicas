package animales;

public class Granja {

    public static void main(String[] args) {

        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);


    }

    public static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoro){ ((Carnivoro) animal).comerCarne();}
        if (animal instanceof Herviboro) {((Herviboro) animal).comerHierba();}

    }
}
