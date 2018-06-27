package com.example.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
