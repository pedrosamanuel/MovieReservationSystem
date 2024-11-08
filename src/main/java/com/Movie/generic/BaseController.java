package com.Movie.generic;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseController<T, DTO, S extends BaseService<T,DTO, R, ID>,R extends BaseRepository<T,ID> , ID>{

    private final S service;

    protected BaseController(S service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable ID id) {
        Optional<DTO> entity = service.findByIdDTO(id);
        return entity.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> create(@RequestBody T entity) {
        service.save(entity);
        return ResponseEntity.ok("Entity Created");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable ID id, @RequestBody T entity) {
        Boolean isUpdated = service.update(id,entity);
        if (isUpdated) {
            return ResponseEntity.ok("EntityUpdated");
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable ID id) {
        Boolean isDeleted = service.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Entity deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
