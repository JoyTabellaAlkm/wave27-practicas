package com.meli.movies.service;

import com.meli.movies.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> seriesByNumberOfSeasons(Integer numberOfSeasons);
}
