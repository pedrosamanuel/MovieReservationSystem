package com.Movie.repository;

import com.Movie.entity.Movie;
import com.Movie.generic.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends BaseRepository<Movie, Long> {
}
