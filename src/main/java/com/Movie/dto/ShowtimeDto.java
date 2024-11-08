package com.Movie.dto;

import com.Movie.entity.Movie;
import com.Movie.entity.Room;
import com.Movie.generic.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShowtimeDto extends BaseDto<Long> {
    private LocalDateTime dateTimeAt;
    private Movie movie;
    private Room room;
}
