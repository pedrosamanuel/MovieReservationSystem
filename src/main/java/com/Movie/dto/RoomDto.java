package com.Movie.dto;

import com.Movie.entity.Seat;
import com.Movie.generic.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoomDto extends BaseDto<Long> {
    private int numberRoom;
    private String location;
    private List<Seat> seats;
}
