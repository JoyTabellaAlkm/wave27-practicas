package ar.com.mercadolibre.ejercicioDeportistas.entitys;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class Deporte{
    private String nombre;
    private String nivel;

    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString(){
        return "{Deporte: " + getNombre() +
                ", " + "Nivel: " + getNivel() + "}";
    }



}
