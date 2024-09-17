package herencia;

public class POOMain {
    public static void main(String[] args) {

        Animal perro = new Perro("Perro", "Tyger");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("Gato", "Garfield");
        gato.hacerSonido();
        gato.mostrarEspecie();

    }
}
