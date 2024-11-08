package com.Movie.entity;

import com.Movie.generic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Room extends BaseEntity<Long> {
    private int numberRoom;
    private String location;
    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Seat> seats;
}
