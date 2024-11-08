package com.Movie.dto;

import com.Movie.entity.Room;
import com.Movie.entity.Seat;
import com.Movie.generic.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SeatDto extends BaseDto<Seat> {
    private int numberSeat;
    private char letterSeat;
    private Room room;
}
