public class Participante {
    public int numeroParticipante;
    public int dni;
    public String nombre;
    public String apellido;
    public int edad;
    public String celular;
    public String numeroEmergencia;
    public String grupoSanguineo;

    public Participante(int numParticipante, int dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
this.numeroParticipante = numParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return
                "Número de participante: " + numeroParticipante + ", DNI: " + dni +
                ", Nombre: " + nombre + " " +
                apellido +
                ", Edad: " + edad +
                ", Celular: " + celular +
                ", Numero de emergencia: " + numeroEmergencia +
                ", Grupo sanguíneo: " + grupoSanguineo;
    }
}
