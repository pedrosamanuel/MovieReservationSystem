package com.Movie.dto;

import com.Movie.entity.ReserveState;
import com.Movie.entity.Seat;
import com.Movie.entity.Showtime;
import com.Movie.generic.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReserveDto extends BaseDto<Long> {
    private LocalDateTime dateTime;
    private Showtime showtime;
    private ReserveState reserveState;
    private List<Seat> seats;
}
