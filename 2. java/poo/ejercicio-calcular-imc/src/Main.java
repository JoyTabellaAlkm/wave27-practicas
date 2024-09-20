public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Sebastian",25,"1389287442");
        Persona persona3 = new Persona("Santiago",22,"32876723",90,1.75);

        //Persona persona4 = new Persona("Mariany",23); no se puede porque no existe un constructor que acepte solo esos dos parametros.

        double imc = persona3.calcularIMC();
        System.out.println(persona3.toString());
        if(persona3.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        }else {
            System.out.println("La persona es menor de edad");
        }
        System.out.println("IMC: " + imc);
        if(persona3.validarIMC(imc)==-1){
            System.out.println("La persona tiene bajo peso");
        } else if (persona3.validarIMC(imc)==0) {
            System.out.println("la persona tiene peso saludable");
        } else {
            System.out.println("La persona tiene sobrepeso");
        }
    }
}