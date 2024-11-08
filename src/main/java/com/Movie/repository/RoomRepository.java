package com.Movie.repository;

import com.Movie.entity.Room;
import com.Movie.generic.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends BaseRepository<Room, Long> {
}
