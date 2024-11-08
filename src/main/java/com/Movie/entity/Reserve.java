package com.Movie.entity;

import com.Movie.generic.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserve extends BaseEntity<Long> {
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "showtime_fk")
    private Showtime showtime;
    @Enumerated(EnumType.STRING)
    private ReserveState reserveState;
    @ManyToMany
    @JoinTable(name = "reserve_seat",
            joinColumns = @JoinColumn(name = "reserve_fk"),
            inverseJoinColumns = @JoinColumn(name = "seat_fk")
    )
    private List<Seat> seats;
    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;
}
