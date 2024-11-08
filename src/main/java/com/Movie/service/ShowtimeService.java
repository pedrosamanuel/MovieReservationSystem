package com.Movie.service;

import com.Movie.dto.ShowtimeDto;
import com.Movie.entity.Showtime;
import com.Movie.generic.BaseService;
import com.Movie.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowtimeService extends BaseService<Showtime, ShowtimeDto, ShowtimeRepository, Long> {
    private final ShowtimeRepository showtimeRepository;
    protected ShowtimeService(ShowtimeRepository repository, ShowtimeRepository showtimeRepository) {
        super(repository);
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    protected Showtime updateEntity(Showtime entity, Showtime updatedEntity) {
        entity.setDateTimeAt(updatedEntity.getDateTimeAt());
        entity.setMovie(updatedEntity.getMovie());
        entity.setRoom(updatedEntity.getRoom());
        return entity;
    }

    @Override
    protected ShowtimeDto convertToDTO(Showtime entity) {
        ShowtimeDto dto = new ShowtimeDto();
        dto.setId(entity.getId());
        dto.setDateTimeAt(entity.getDateTimeAt());
        dto.setMovie(entity.getMovie());
        dto.setRoom(entity.getRoom());
        return dto;
    }

    public List<ShowtimeDto> findByDate(LocalDate date) {
        List<Showtime> showtimes = showtimeRepository.findByDate(date);
        return showtimes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
