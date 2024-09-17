package herencia;

public class Animal {

    private String especie;

    public void hacerSonido(){
        System.out.println("El animal hace un sonido");
    }

    public void mostrarEspecie(){
        System.out.println("Soy un animal de la especia: " + this.especie);
    }

    public Animal(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
