package com.example.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
