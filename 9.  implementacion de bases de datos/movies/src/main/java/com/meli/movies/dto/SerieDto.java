package com.meli.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDto {
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Integer genreId;
}
