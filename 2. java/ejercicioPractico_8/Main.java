public class Main {
    /*
     * En la clase Main que acabamos de crear, dentro del método main()
     * te pedimos que crees un objeto de tipo Persona por cada constructor
     *  que hayamos definido en la clase, recuerda poner un nombre significativo
     *  a las variables donde vas a asignar cada objeto.
     * ¿Cómo lo harías? A continuación vamos a crear otro objeto de tipo persona y
     * vamos a construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor.
     * ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?
     * */
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona personaConInfoParcial = new Persona("Stephanie","38414099", 22);

        Persona personaConInfoCompleta = new Persona("Gianella",19, "45678867",50.2,1.60);

        System.out.println("Datos generales del paciente: " + personaConInfoCompleta.toString());

        switch (personaConInfoCompleta.calcularIMC()){
            case 1:
                System.out.println("La persona tiene sobre peso");
                break;
            case 0:
                System.out.println("La persona está con bajo peso");
                break;
            default:
                System.out.println("La persona tiene un peso saludable");
                break;
        }

        if (personaConInfoCompleta.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        }else {
            System.out.println("La persona es menor de edad");
        }
   }
}