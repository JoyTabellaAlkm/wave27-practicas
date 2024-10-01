package POO;

public class Persona {
    /*
     * Creá una clase Persona, la cual tendrá los siguientes
     * atributos: nombre, edad, dni (en este caso vamos a representarlo como una cadena de caracteres),
     * peso y altura ¿Qué tipo de dato le asignarías a las variables de instancia? ¿Cómo sería la estructura básica de tu clase?
     * */

    String nombre;
    String dni;
    int edad;
    double peso;
    double altura;

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    /*
     * Vamos a crear diferentes constructores en la clase Persona, uno sin parámetros, el segundo
     * debe recibir como parámetro nombre, edad y dni; por último creamos un tercero que reciba
     * todos los atributos de la clase como parámetro.
     * */
    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona() {

    }
    /*
      En la clase Persona implementaremos los siguientes métodos: cacularIMC(),
     * la fórmula para calcularlo es: peso/(altura^2) - (peso expresado en kg y altura en mts),
     * si este cálculo devuelve un valor menor que 20, la función debe retornar -1, si devuelve un
     * número entre 20 y 25 inclusive para los dos valores, el método debe retornar un 0, por último,
     * si devuelve un número mayor que 25 debe retornar un 1. Una vez creado el método anterior,
     * agreguemos el método esMayorDeEdad() el cual debe retornar una valor booleano, teniendo en
     * cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años. Finalmente
     * agregar un método toString() que va a devolver toda la información de la persona.
     * ¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.
     */
    public int calcularIMC() {
        double calculoDeIMC=  (peso/(altura*altura));
        int resultado = -1;

        if (calculoDeIMC >= 20 && calculoDeIMC <= 25 ) {
            resultado = 0;
        }else if (calculoDeIMC > 25 ) {
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI:  " + dni + "\nPeso: " + peso + "\nAltura: " + altura;
    }
}
