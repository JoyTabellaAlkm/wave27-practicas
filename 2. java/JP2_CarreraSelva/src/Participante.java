public class Participante{
    private int numeroParticipante, dni, edad, celular, numeroEmergencia;
    private String nombre, apellido, grupoSanguineo;


    public Participante(int numeroParticipante, String nombre, String apellido, int dni, int edad, int celular, int numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}
