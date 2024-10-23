package ar.com.mercadolibre.moviesConsultas.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieResponseDTO {

    private Integer id;

    private String title;

    private Double rating;
    private Integer awards;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    private Integer length;
}
