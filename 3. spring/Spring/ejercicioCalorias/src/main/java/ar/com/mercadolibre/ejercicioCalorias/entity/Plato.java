package ar.com.mercadolibre.ejercicioCalorias.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plato {
    private int id;
    private String namePlato;
    private double peso;
    private List<Ingrediente> ingredienteList;

    @JsonCreator
    public Plato(@JsonProperty("id") int id,
                 @JsonProperty("namePlato") String namePlato,
                 @JsonProperty("pesoTotal") double peso,
                 @JsonProperty("ingredientes") List<Ingrediente> ingredienteList) {
        this.id = id;
        this.namePlato = namePlato;
        this.peso = peso;
        this.ingredienteList = ingredienteList;
    }
}
