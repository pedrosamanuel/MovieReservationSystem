package com.Movie.service;

import com.Movie.dto.ReserveDto;
import com.Movie.dto.request.ReserveRequest;
import com.Movie.entity.Reserve;
import com.Movie.entity.ReserveState;
import com.Movie.entity.User;
import com.Movie.generic.BaseService;
import com.Movie.repository.ReserveRepository;
import com.Movie.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReserveService extends BaseService<Reserve, ReserveDto, ReserveRepository, Long> {
    private final UserRepository userRepository;
    private final ReserveRepository reserveRepository;
    protected ReserveService(ReserveRepository repository, UserRepository userRepository, ReserveRepository reserveRepository) {
        super(repository);
        this.userRepository = userRepository;
        this.reserveRepository = reserveRepository;
    }

    @Override
    protected Reserve updateEntity(Reserve entity, Reserve updatedEntity) {
        entity.setReserveState(updatedEntity.getReserveState());
        entity.setSeats(updatedEntity.getSeats());
        entity.setShowtime(updatedEntity.getShowtime());
        entity.setDateTime(updatedEntity.getDateTime());
        return entity;
    }

    @Override
    protected ReserveDto convertToDTO(Reserve entity) {
        ReserveDto dto = new ReserveDto();
        dto.setDateTime(entity.getDateTime());
        dto.setReserveState(entity.getReserveState());
        dto.setSeats(entity.getSeats());
        dto.setShowtime(entity.getShowtime());
        dto.setId(entity.getId());
        return dto;
    }

    public void save(ReserveRequest request, Long userId) {
        Optional<User> userOptional =
                userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Reserve reserve = Reserve.builder()
                    .dateTime(LocalDateTime.now())
                    .reserveState(ReserveState.CONFIRMED)
                    .user(user)
                    .seats(request.getSeats())
                    .showtime(request.getShowtime())
                    .build();
            reserveRepository.save(reserve);
        }

    }

    public List<ReserveDto> findByUser(Long userId) {
        List<Reserve> reserves =
                reserveRepository.findByUserIdAndUpcoming(userId);
        return reserves.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void cancelReserve(Long reserveId) {
        Optional<Reserve> optionalReserve =
                reserveRepository.findById(reserveId);
        if (optionalReserve.isPresent()){
            Reserve reserve = optionalReserve.get();
            reserve.setReserveState(ReserveState.CANCELED);
            reserveRepository.save(reserve);
        }
    }

    public List<ReserveDto> findByShowtime(Long showtimeId) {
        List<Reserve> reserves =
                reserveRepository.findByShowtimeId(showtimeId);
        return reserves.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
