package ar.com.deportistas.deportistas.dto;

import java.io.Serializable;

public class DeportistaDTO implements Serializable {
    String name;
    String apellido;
    String deporte;

    public DeportistaDTO(String name, String apellido, String deporte) {
        this.name = name;
        this.apellido = apellido;
        this.deporte = deporte;
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}