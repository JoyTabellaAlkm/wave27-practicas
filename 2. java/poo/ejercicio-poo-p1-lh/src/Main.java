public class Main {
    public static void main(String[] args) {

        /* ENUNCIADO:
        Al momento de crear la clase Automovil se han cometido algunos errores en su diseño. ¿Puedes identificarlos y corregirlos siguiendo lo que has aprendido acerca de ellas?
        Pistas:Recuerda las palabras reservadas y la sintáxis que hemos aprendido para la creación de clases y la construcción de los métodos.

        public Automovil {

            private String marca;
            private String color;
            private double kilometros;

            public Automovil() {

            }

            public Automovil(marca, color, kilometros) {
                    this.marca = marca;
                    this.color = color;
                    this.kilometros = kilometros;
            }

            public String mostrarMarcaYColor() {
                    String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            }
}*/

        Automovil automovil = new Automovil("BMW","Blanco",0);
        System.out.println(automovil.mostrarMarcaYColor());
    }
}