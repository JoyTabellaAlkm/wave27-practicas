public class Main {
    public static void main(String[] args) {
        Persona personaNN = new Persona();
        Persona persona1 = new Persona("Fulanito", 23, "1033954");
        Persona persona2 = new Persona("Anita", 34, "28948243", 60, 1.54);

        //Esta declaracion arroja error ya que no hay un constructor creado para esta cantidad y tipo de parametros
        //Persona prueba = new Persona("Felipe", 34);

        int imc = persona2.calcularIMC();
        if(imc == -1) System.out.println("Esta bajo de peso");
        if(imc == 0) System.out.println("Esta de peso saludable");
        if(imc == 1) System.out.println("Esta con sobrepeso");
        if(persona2.esMayorDeEdad()) System.out.println("Es mayor de edad");
        else System.out.println("Es menor de edad");
        System.out.println(persona2);
    }
}