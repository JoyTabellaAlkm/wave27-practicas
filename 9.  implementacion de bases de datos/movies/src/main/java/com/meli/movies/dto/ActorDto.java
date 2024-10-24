package com.meli.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
}
