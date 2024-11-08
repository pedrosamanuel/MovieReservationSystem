package com.Movie.entity;

import com.Movie.generic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Movie extends BaseEntity<Long> {
    private String name;
    private String description;
    private String posterImgUrl;
    private int minutesDuration;
    @ManyToOne
    @JoinColumn(name = "genre_fk")
    private Genre genre;
}
