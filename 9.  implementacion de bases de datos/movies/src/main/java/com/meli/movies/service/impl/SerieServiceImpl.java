package com.meli.movies.service.impl;

import com.meli.movies.dto.SerieDto;
import com.meli.movies.repository.ISerieRepository;
import com.meli.movies.service.ISerieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {
    private final ISerieRepository serieRepository;
    private ModelMapper mapper = new ModelMapper();

    public SerieServiceImpl(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDto> seriesByNumberOfSeasons(Integer numberOfSeasons) {
        return serieRepository.seriesByNumberOfSeasons(numberOfSeasons).stream()
                .map(serie -> mapper.map(serie, SerieDto.class))
                .toList();
    }
}
