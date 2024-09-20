package ar.com.mercadolibre.ejercicioCalorias.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private int id;
    private String namePlato;
    private double peso;
    private List<Ingrediente> ingredienteList;
}
