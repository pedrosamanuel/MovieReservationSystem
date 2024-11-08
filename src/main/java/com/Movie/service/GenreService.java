package com.Movie.service;

import com.Movie.dto.GenreDto;
import com.Movie.entity.Genre;
import com.Movie.generic.BaseService;
import com.Movie.repository.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends BaseService<Genre, GenreDto, GenreRepository, Long> {
    protected GenreService(GenreRepository repository) {
        super(repository);
    }

    @Override
    protected Genre updateEntity(Genre entity, Genre updatedEntity) {
        entity.setName(updatedEntity.getName());
        return entity;
    }

    @Override
    protected GenreDto convertToDTO(Genre entity) {
        GenreDto dto = new GenreDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
