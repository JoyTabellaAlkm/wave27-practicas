public class Main {
    public static void main(String[] args){

        Persona personIncomplete = new Persona();
        Persona personPartial = new Persona("luisa",12,"122121");
        Persona personComplete = new Persona("laura",18, "1234",67.0,1.62);
        //Persona personError = new Persona("jorge",19);
        calculateWeight(personComplete);
        boolean result = personComplete.esMayorDeEdad();
        isLegalAge(result);
    }

    private static void isLegalAge(boolean result) {
        if(result){
            System.out.println("la pesona es mayor de edad");
        }
    }

    private static void calculateWeight(Persona personComplete) {
        int result = personComplete.cacularIMC();
        if(result== -1){
            System.out.println("la persona tiene bajo peso");
        } else if(result==0){
            System.out.println("la persona tiene un peso saludable");
        }
        else{
            System.out.println("la persona esta en sobrepeso");
        }
    }


}