package com.Movie.dto.request;

import com.Movie.entity.Seat;
import com.Movie.entity.Showtime;
import lombok.Data;

import java.util.List;
@Data
public class ReserveRequest {
    private Showtime showtime;
    private List<Seat> seats;
}
