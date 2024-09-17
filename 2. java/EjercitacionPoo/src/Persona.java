public class Persona {

    private String nombre;
    private Integer edad;
    private String dni;
    private Integer peso;
    private Integer altura;

    public Persona(){
        this.altura = 180;
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, Integer peso, Integer altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " - Edad: " + edad +
                " - DNI: " + dni +
                " - Peso:" + peso +
                " - Altura:" + altura;
    }

    public int calcularIMC(){

        double imc = (this.peso/Math.pow((double) this.altura / 100, 2));
        System.out.println(imc);
        if (imc < 20){
            return -1;
        }

        if (imc <= 25){
            return  0;
        }

        return 1;
    }

    public boolean esMayor(){
        return this.edad >= 18;
    }
}
