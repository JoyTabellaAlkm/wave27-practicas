public class Main{
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        comerAnimal(gato);
        gato.emitirSonido();

        comerAnimal(perro);
        perro.emitirSonido();

        comerAnimal(vaca);
        vaca.emitirSonido();

    }

    public static void comerAnimal(Animal animal){
        if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        } else {
            ((Carnivoro) animal).comerCarne();
        }
    }
}