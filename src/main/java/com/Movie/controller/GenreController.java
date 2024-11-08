package com.Movie.controller;

import com.Movie.dto.GenreDto;
import com.Movie.entity.Genre;
import com.Movie.generic.BaseController;
import com.Movie.repository.GenreRepository;
import com.Movie.service.GenreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genre")
public class GenreController extends BaseController<Genre, GenreDto, GenreService, GenreRepository, Long> {
    public GenreController(GenreService service) {
        super(service);
    }
}
