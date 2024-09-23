//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Sebastian",25,"1389287442");
        Persona persona3 = new Persona("Sebastian",25,"3287672322",80,1.75);

        //Persona persona4 = new Persona("Mariany",23);

        double imc = persona3.calcularIMC();


        System.out.println(persona3.toString() + "\n");
        System.out.println("IMC: " + imc);
        int valorImc = persona3.validarIMC(imc);

        if(persona3.esMayorDeEdad()){
            System.out.println("\nEs mayor de edad");
        }else {
            System.out.println("\nEs menor de edad");
        }

    }
}