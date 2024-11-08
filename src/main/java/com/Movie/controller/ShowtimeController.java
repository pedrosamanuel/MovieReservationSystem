package com.Movie.controller;

import com.Movie.dto.ShowtimeDto;
import com.Movie.entity.Showtime;
import com.Movie.generic.BaseController;
import com.Movie.repository.ShowtimeRepository;
import com.Movie.service.SeatService;
import com.Movie.service.ShowtimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/showtime")
public class ShowtimeController extends BaseController<Showtime, ShowtimeDto, ShowtimeService, ShowtimeRepository, Long> {

    private final ShowtimeService showtimeService;
    protected ShowtimeController(ShowtimeService service, ShowtimeService showtimeService) {
        super(service);
        this.showtimeService = showtimeService;
    }
    @GetMapping("/by-date")
    public ResponseEntity<List<ShowtimeDto>> getShowtimesByDate(@RequestParam("date") LocalDate date){
        return ResponseEntity.ok(showtimeService.findByDate(date));
    }


}
