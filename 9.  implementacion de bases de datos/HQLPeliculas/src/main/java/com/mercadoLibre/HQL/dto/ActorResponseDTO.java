package com.mercadoLibre.HQL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;
    private String favoriteMovie;
}
