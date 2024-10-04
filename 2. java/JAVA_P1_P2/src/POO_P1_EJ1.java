public class POO_P1_EJ1 {
    public static void main(String[] args) {
        Automovil auto1 = new Automovil();
        Automovil auto2 = new Automovil("audi","red",20000);
    }
    //Ejercicio que arregla errores de ejercicios
    public static class Automovil {

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

        public String mostrarMarcaYColor() {
            String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            return marcaYColor;
        }
    }
}
