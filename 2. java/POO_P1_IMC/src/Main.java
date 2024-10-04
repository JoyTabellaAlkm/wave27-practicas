public class Main {
    public static void main(String[] args) {
        Person delfi = new Person();
        Person ana = new Person("Ana", 24, "2546875");
        Person anto = new Person("Anto",30, "38068706",80.0,1.60);
        //Person prueba = new Person("pepito",25); Da error porque no existe ese tipo de constructor.

        System.out.println(anto.toString());

        if (anto.calculateIMC() == -1) {
            System.out.println("Diagnostico: Bajo Peso");
        }
        if (anto.calculateIMC() == 0) {
            System.out.println("Diagnostico: Poco saludable");
        }
        if (anto.calculateIMC() == 1) {
            System.out.println("Diagnostico: Sobrepeso");
        }


        if(anto.isOverAge()) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }

        
    }


}