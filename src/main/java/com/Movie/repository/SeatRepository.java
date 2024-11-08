package com.Movie.repository;

import com.Movie.entity.Seat;
import com.Movie.generic.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends BaseRepository<Seat, Long> {

    List<Seat> findByRoomId(Long roomId);
    @Query("SELECT s From Showtime st JOIN st.room.seats s WHERE st.id = :showtimeId " +
            "AND s.id NOT IN (SELECT rs.id FROM Reserve r JOIN r.seats rs WHERE r.showtime.id = :showtimeId AND r.reserveState = 'CONFIRMED')")
    List<Seat> findSeatsAvailable(@Param("showtimeId") Long showtimeId);
}
