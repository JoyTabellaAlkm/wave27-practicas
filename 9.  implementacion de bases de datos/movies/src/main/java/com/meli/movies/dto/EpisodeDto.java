package com.meli.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private Double rating;
    private Integer seasonId;
}
