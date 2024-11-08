package com.Movie.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<T,DTO, R extends BaseRepository<T,ID>, ID> {

    private final R repository;

    protected BaseService(R repository) {
        this.repository = repository;
    }

    public List<DTO> findAll() {
        List<T> list = repository.findAll();
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Page<T> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<DTO> findByIdDTO(ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(this::convertToDTO);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }


    public void save(T entity) {
        repository.save(entity);
    }

    public Boolean deleteById(ID id) {
        Optional<T> existingEntity = repository.findById(id);
        if (existingEntity.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean update(ID id, T updatedEntity) {
        Optional<T> existingEntity = repository.findById(id);
        if (existingEntity.isPresent()) {
            T entity = existingEntity.get();
            T updated = updateEntity(entity, updatedEntity);
            repository.save(updated);
            return true;
        }
        return false;
    }

    protected abstract T updateEntity(T entity, T updatedEntity);

    protected abstract DTO convertToDTO(T entity);

}
