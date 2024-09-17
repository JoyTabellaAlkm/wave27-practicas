package Integrador;

public class Cliente {
    private String dni;

    private String name;

    private String apellido;

    public Cliente(String dni, String name, String apellido) {
        this.dni = dni;
        this.name = name;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
