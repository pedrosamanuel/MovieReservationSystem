package com.Movie.repository;

import com.Movie.entity.Genre;
import com.Movie.generic.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends BaseRepository<Genre,Long> {
}
