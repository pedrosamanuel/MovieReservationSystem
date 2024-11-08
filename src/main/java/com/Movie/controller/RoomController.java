package com.Movie.controller;

import com.Movie.dto.RoomDto;
import com.Movie.entity.Room;
import com.Movie.generic.BaseController;
import com.Movie.repository.RoomRepository;
import com.Movie.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
public class RoomController extends BaseController<Room, RoomDto, RoomService, RoomRepository, Long> {
    protected RoomController(RoomService service) {
        super(service);
    }
}
