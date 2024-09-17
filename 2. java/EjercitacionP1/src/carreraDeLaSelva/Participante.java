package carreraDeLaSelva;

public class Participante {
    private int numeroParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;

    public Participante(int numeroParticipante, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroParticipante(){
        return numeroParticipante;
    }

    @Override
    public String toString() {
        return "NumeroParticipante: " + numeroParticipante +
                ", DNI: " + dni +
                ", Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Edad: " + edad;
    }
}