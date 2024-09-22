public class Main {
    public static void main(String[] args) {
        Persona personaSinNombre = new Persona();
        Persona juan = new Persona("Juan", 25, "12345678A");
        Persona pedro = new Persona("Pedro", 17, "87654321B", 100, 1.75);

        /* java: no suitable constructor found for Persona(java.lang.String,int)
        Persona personaError = new Persona("Error", 25);*/

        int valorIMC = pedro.calcularIMC();
        boolean esMayor = pedro.esMayorDeEdad();

        System.out.println("Pedro es mayor de edad: " + esMayor);
        System.out.println(pedro);

        switch (valorIMC){
            case -1:
                System.out.println("Pedro tiene bajo peso " + pedro.getPeso());
                break;
            case 0:
                System.out.println("Pedro tiene peso saludable " + pedro.getPeso());
                break;
            case 1:
                System.out.println("Pedro tiene sobrepeso " + pedro.getPeso());
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}