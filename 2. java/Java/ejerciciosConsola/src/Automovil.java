public class Automovil {

    String marca;
    String color;
    double kilometros;

    public Automovil() {

    }

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor(String marca, String color) {
        String marcaYColor = "La marca del auto es: " + marca + ". El color del auto es: " + color;
        return marcaYColor;
    }

    public static void main(String[] args){
        Automovil automovil = new Automovil();
        System.out.println(automovil.mostrarMarcaYColor("Chevrolet", "Rojo"));
    }
}
