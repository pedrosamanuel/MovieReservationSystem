package com.Movie.repository;

import com.Movie.entity.Showtime;
import com.Movie.generic.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowtimeRepository extends BaseRepository<Showtime, Long> {

    @Query("SELECT s FROM Showtime s WHERE DATE(s.dateTimeAt) = :date")
    List<Showtime> findByDate(@Param("date") LocalDate date);
}
