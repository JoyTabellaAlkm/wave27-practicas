public class Persona {
    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Persona() {
    }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int cacularIMC() {
        double calculate = this.weight / Math.pow(this.height, 2);
        if (calculate < 20) {
            return -1;
        } else if (calculate >= 20 && calculate <= 25) {
            return 0;

        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return this.age >=18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
