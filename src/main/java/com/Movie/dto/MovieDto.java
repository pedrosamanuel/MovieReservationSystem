package com.Movie.dto;

import com.Movie.entity.Genre;
import com.Movie.entity.Movie;
import com.Movie.generic.BaseDto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class MovieDto extends BaseDto<Long> {
    private String name;
    private String description;
    private String posterImgUrl;
    private int minutesDuration;
    private String genreName;
}
