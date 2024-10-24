package com.meli.movies.service.impl;

import com.meli.movies.dto.EpisodeDto;
import com.meli.movies.repository.IEpisodeRepository;
import com.meli.movies.service.IEpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements IEpisodeService {
    private final IEpisodeRepository episodeRepository;
    private ModelMapper mapper = new ModelMapper();

    public EpisodeServiceImpl(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<EpisodeDto> episodeByActor(String actorName) {
        return episodeRepository.findEpisodesByActorName(actorName).stream()
                .map(episode -> mapper.map(episode, EpisodeDto.class))
                .toList();
    }
}
