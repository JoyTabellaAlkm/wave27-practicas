package ar.com.mercadolibre.moviesConsultas.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActorResponseDTO {

    private Integer id;

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    private Double rating;

    @JsonProperty("favorite_movie_id")
    private Integer favoriteMovieId;
}
