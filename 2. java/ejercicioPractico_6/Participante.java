public class Participante {
    /*
     Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción, proporcionar
     los siguientes datos: número de participante, dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.
    * */

    private String nombre;
    private String apellido;
    private String dni;
    private Integer edad;
    private Integer telefono;
    private Integer telefonoDeEmergencia;
    private String grupoSanguineo;
    private Integer circuitoElegido;
    private Circuito circuito;

    public Participante(String nombre, String apellido, String dni, Integer edad, Integer telefono, Integer telefonoDeEmergencia, String grupoSanguineo, Integer circuitoElegido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.telefonoDeEmergencia = telefonoDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.circuitoElegido = circuitoElegido;
        this.circuito = new Circuito(circuitoElegido);
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido+ "\nEdad: " + edad + "\nDNI:  " + dni + "\nTelefono: " + telefono + "\nTelefono de emercencia: " + telefonoDeEmergencia + "\nGrupo sanguineo: " + grupoSanguineo;
    }

    public Integer getImporteDelCircuito() {
        return this.circuito.precioSegunCircuito(this.circuitoElegido);
    }
}
