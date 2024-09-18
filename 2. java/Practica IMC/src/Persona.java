public class Persona {

        public static final int EDAD_MAYOR = 18;
        private String nombre;
        private int edad;
        private String dni;
        private double peso;
        private double altura;

        public Persona() {
            this.nombre = "";
            this.edad = 0;
            this.dni = "";
            this.peso = 0;
            this.altura = 0;
        }

        public Persona(String nombre, int edad, String dni) {
            this.nombre = nombre;
            this.edad = edad;
            this.dni = dni;
            this.peso = 0;
            this.altura = 0;
        }

        public Persona(String nombre, int edad, String dni, double peso, double altura) {
            this.nombre = nombre;
            this.edad = edad;
            this.dni = dni;
            this.peso = peso;
            this.altura = altura;
        }

        public int calcularIMC() {
            double imc = peso / Math.pow(altura, 2);

            if (imc < 20) {
                return -1;
            } else if (imc <= 25) {
                return 0;
            } else {
                return 1;
            }
        }

        public boolean esMayorDeEdad() {
            return edad > EDAD_MAYOR;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", dni='" + dni + '\'' +
                    ", peso=" + peso +
                    ", altura=" + altura +
                    '}';
        }
    }

