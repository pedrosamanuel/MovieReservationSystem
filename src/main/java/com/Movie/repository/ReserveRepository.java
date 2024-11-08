package com.Movie.repository;

import com.Movie.entity.Reserve;
import com.Movie.generic.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends BaseRepository<Reserve, Long> {

    @Query("Select r from Reserve r where r.showtime.dateTimeAt > CURRENT_TIMESTAMP AND r.user.id = :userId")
    List<Reserve> findByUserIdAndUpcoming(@Param("userId") Long userId);

    List<Reserve> findByShowtimeId(Long showtimeId);
}
