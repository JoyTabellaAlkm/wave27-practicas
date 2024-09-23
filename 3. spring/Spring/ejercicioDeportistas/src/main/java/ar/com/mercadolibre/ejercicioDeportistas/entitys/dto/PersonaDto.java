package ar.com.mercadolibre.ejercicioDeportistas.entitys.dto;

import ar.com.mercadolibre.ejercicioDeportistas.entitys.Persona;

public class PersonaDto {
    private String nombrePersona;
    private String apellido;
    private String nombreDeporte;

    public PersonaDto(String nombrePersona, String apellido, String nombreDeporte){
        this.nombrePersona = nombrePersona;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }

    public static PersonaDto from(Persona persona) {
        return new PersonaDto(persona.getNombre(),
                persona.getApellido(),
                persona.getDeporte().getNombre());
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                '}';
    }
}

