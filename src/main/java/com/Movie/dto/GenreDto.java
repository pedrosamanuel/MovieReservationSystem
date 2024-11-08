package com.Movie.dto;

import com.Movie.generic.BaseDto;
import lombok.Data;

@Data
public class GenreDto extends BaseDto<Long> {
    private String name;
}
