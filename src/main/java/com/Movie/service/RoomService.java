package com.Movie.service;

import com.Movie.dto.RoomDto;
import com.Movie.entity.Room;
import com.Movie.generic.BaseService;
import com.Movie.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<Room, RoomDto, RoomRepository, Long> {
    protected RoomService(RoomRepository repository) {
        super(repository);
    }

    @Override
    protected Room updateEntity(Room entity, Room updatedEntity) {
        entity.setLocation(updatedEntity.getLocation());
        entity.setNumberRoom(updatedEntity.getNumberRoom());
        entity.setSeats(updatedEntity.getSeats());
        return entity;
    }

    @Override
    protected RoomDto convertToDTO(Room entity) {
        RoomDto dto = new RoomDto();
        dto.setLocation(entity.getLocation());
        dto.setNumberRoom(entity.getNumberRoom());
        dto.setSeats(entity.getSeats());
        dto.setId(entity.getId());
        return dto;
    }
}
