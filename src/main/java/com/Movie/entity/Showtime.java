package com.Movie.entity;

import com.Movie.generic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Showtime extends BaseEntity<Long> {
    private LocalDateTime dateTimeAt;
    @ManyToOne
    @JoinColumn(name = "movie_fk")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "room_fk")
    private Room room;
}
