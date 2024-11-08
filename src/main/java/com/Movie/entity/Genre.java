package com.Movie.entity;

import com.Movie.generic.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Genre extends BaseEntity<Long> {
    private String name;
}
