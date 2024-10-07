public class Participante {
    @Override
    public String toString() {
        return "Participante{" +
                "numeroParticipante=" + numeroParticipante +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", telefonoEmergencia=" + telefonoEmergencia +
                ", celular=" + celular +
                '}';
    }

    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String grupoSanguineo;
    private long telefonoEmergencia;
    private long celular;

    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, String grupoSanguineo, long telefonoEmergencia, long celular) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.grupoSanguineo = grupoSanguineo;
        this.telefonoEmergencia = telefonoEmergencia;
        this.celular = celular;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public long getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(long telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

}
