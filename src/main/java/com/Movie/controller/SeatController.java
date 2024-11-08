package com.Movie.controller;

import com.Movie.entity.Seat;
import com.Movie.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seat")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/showtime/{showtimeId}")
    public ResponseEntity<List<Seat>> getSeatsAvailable (@PathVariable Long showtimeId){
        return ResponseEntity.ok(seatService.getSeatsAvailable(showtimeId));

    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<Seat>> getSeatsByRoom(@PathVariable Long roomId) {
        return ResponseEntity.ok(seatService.getSeatsByRoomId(roomId));
    }

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        return ResponseEntity.ok(seatService.saveSeat(seat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return ResponseEntity.noContent().build();
    }
}
