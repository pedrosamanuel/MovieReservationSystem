package com.Movie.service;

import com.Movie.dto.MovieDto;
import com.Movie.entity.Movie;
import com.Movie.generic.BaseService;
import com.Movie.repository.MovieRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends BaseService<Movie, MovieDto, MovieRepository, Long> {
    public MovieService(MovieRepository repository) {
        super(repository);
    }

    @Override
    protected Movie updateEntity(Movie entity, Movie updatedEntity) {
        entity.setDescription(updatedEntity.getDescription());
        entity.setName(updatedEntity.getName());
        entity.setGenre(updatedEntity.getGenre());
        entity.setMinutesDuration(updatedEntity.getMinutesDuration());
        entity.setPosterImgUrl(updatedEntity.getPosterImgUrl());
        return entity;
    }

    @Override
    protected MovieDto convertToDTO(Movie entity) {
        MovieDto dto = new MovieDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setName(entity.getName());
        dto.setMinutesDuration(entity.getMinutesDuration());
        dto.setPosterImgUrl(entity.getPosterImgUrl());
        dto.setGenreName(entity.getGenre().getName());
        return dto;
    }
}
