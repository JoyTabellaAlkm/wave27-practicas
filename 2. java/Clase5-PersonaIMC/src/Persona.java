public class Persona {
    //Atributos
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //Constructores

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
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
        double imc = this.peso / (this.altura * this.altura);
        int resultado = -1;
        if (imc>=20 && imc<=25){
            resultado = 0;
        } else if (imc>25) {
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad(){
        return (this.edad >= 18);
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\nedad: " + this.edad + "\ndni: " + this.dni + "\npeso: " + this.peso + "\naltura: " + this.altura;
    }
}
