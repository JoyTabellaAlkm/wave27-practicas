public class Participante {
    public int numeroParticipante;
    public int dni;
    public String nombre;
    public String apellido;
    public int edad;
    public long celular;
    public long numeroEmergencia;
    public String grupoSanguineo;

    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, long celular, long numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public Participante() {
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numeroParticipante=" + numeroParticipante +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numeroEmergencia=" + numeroEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
