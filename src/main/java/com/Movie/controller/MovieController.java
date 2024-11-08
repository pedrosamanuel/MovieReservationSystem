package com.Movie.controller;

import com.Movie.dto.MovieDto;
import com.Movie.entity.Movie;
import com.Movie.generic.BaseController;
import com.Movie.repository.MovieRepository;
import com.Movie.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController extends BaseController<Movie, MovieDto, MovieService, MovieRepository, Long> {
    public MovieController(MovieService service) {
        super(service);
    }
}
