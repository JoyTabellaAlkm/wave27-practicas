package com.meli.movies.service;

import com.meli.movies.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> episodeByActor(String actorName);
}
