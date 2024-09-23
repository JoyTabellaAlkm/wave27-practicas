public class Persona {
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
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return (int )this.peso/(this.altura*this.altura);
    }

    public int validarIMC(double imc){
        if (imc < 20){
            System.out.println("Bajo peso");
            return -1;
        }else if (imc >= 20 && imc <= 25){
            System.out.println("Peso normal");
            return 0;
        } else{
            System.out.println("Sobrepeso");
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if (this.edad >= 18){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Datos de la persona:" +"\n"+
                "nombre= " + nombre + "\n" +
                "edad= " + edad +"\n" +
                "dni= " + dni + "\n" +
                "peso= " + peso + "\n" +
                "altura= " + altura;
    }
}
