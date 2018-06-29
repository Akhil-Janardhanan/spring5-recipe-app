package com.example.recipe.services;

import java.util.Set;

import com.example.recipe.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
}
