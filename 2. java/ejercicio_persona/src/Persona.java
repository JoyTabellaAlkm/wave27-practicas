public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
        this.nombre = "Persona sin parametros";
        this.edad = 0;
        this.dni = "0";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona (String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double resultado = peso/(Math.pow(altura, 2));
        if (resultado < 20){
            return -1;
        }
        if (resultado <= 25){
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public String toString(){
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + dni + "\nPeso: " + peso + "\nAltura: " + altura;
    }

    public double getPeso() {
        return peso;
    }
}
