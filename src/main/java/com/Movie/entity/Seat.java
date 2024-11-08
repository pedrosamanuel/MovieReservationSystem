package com.Movie.entity;

import com.Movie.generic.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Seat extends BaseEntity<Long> {
    private int numberSeat;
    private char letterSeat;
    @ManyToOne
    @JoinColumn(name = "room_fk")
    private Room room;
}
