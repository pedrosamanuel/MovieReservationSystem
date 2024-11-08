package com.Movie.controller;

import com.Movie.dto.ReserveDto;
import com.Movie.dto.request.ReserveRequest;
import com.Movie.entity.Reserve;
import com.Movie.entity.ReserveState;
import com.Movie.generic.BaseController;
import com.Movie.repository.ReserveRepository;
import com.Movie.security.jwt.JwtUtils;
import com.Movie.security.service.UserDetailsImpl;
import com.Movie.security.service.UserDetailsServiceImpl;
import com.Movie.service.ReserveService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserve")
public class ReserveController extends BaseController<Reserve, ReserveDto, ReserveService, ReserveRepository, Long> {
    private final ReserveService reserveService;
    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    protected ReserveController(ReserveService service, ReserveService reserveService, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsServiceImpl) {
        super(service);
        this.reserveService = reserveService;
        this.jwtUtils = jwtUtils;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping("/user")
    public ResponseEntity<List<ReserveDto>> getAllByUser(@CookieValue(name = "jwtToken") String cookie) {
        String username = jwtUtils.getUserNameFromJwtToken(cookie);
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetailsServiceImpl.loadUserByUsername(username);

        return ResponseEntity.ok(reserveService.findByUser(userDetailsImpl.getId()));
    }

    @PostMapping("/user")
    public ResponseEntity<String> createWithUser(@RequestBody ReserveRequest reserveRequest,
                                         @CookieValue(name = "jwtToken") String cookie) {
        String username = jwtUtils.getUserNameFromJwtToken(cookie);
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetailsServiceImpl.loadUserByUsername(username);
        reserveService.save(reserveRequest, userDetailsImpl.getId());
        return ResponseEntity.ok("Entity Created");
    }
    @PutMapping("/cancel/{reserveId}")
    public ResponseEntity<String> cancelReserve(@PathVariable Long reserveId) {
        reserveService.cancelReserve(reserveId);
        return ResponseEntity.ok("Reserve canceled");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/showtime/{showtimeId}")
    public ResponseEntity<List<ReserveDto>> getReservationByShowtime (@RequestParam("showtimeId") Long showtimeId){
        return ResponseEntity.ok(reserveService.findByShowtime(showtimeId));
    }


}
