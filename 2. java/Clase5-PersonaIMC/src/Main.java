public class Main {
    public static void main(String[] args) {
        Persona personaSinInfo =new Persona();
        Persona personaInfoParcial =new Persona("Maria", 20, "12345");
        Persona personaInfoCompleta =new Persona("Jose", 10, "45567", 40.2, 1.60);

        //Persona personaError = new Persona("Mariana", 18);

        System.out.println(personaInfoCompleta.toString());
        int imcPersonaInfoCompleta = personaInfoCompleta.calcularIMC();

        if (imcPersonaInfoCompleta == -1){
            System.out.println("La persona tiene bajo peso");
        } else if (imcPersonaInfoCompleta == 0) {
            System.out.println("El persona tiene un peso saludable");
        } else {
            System.out.println("El persona tiene sobrepeso");
        }

        if (personaInfoCompleta.esMayorDeEdad()){
            System.out.println("El persona es mayor de edad");
        } else {
            System.out.println("El persona no es mayor de edad");
        }
    }
}