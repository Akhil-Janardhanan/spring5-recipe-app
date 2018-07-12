package com.example.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.commands.CategoryCommand;
import com.example.recipe.commands.IngredientCommand;
import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.domain.Recipe;

import lombok.Synchronized;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe>{

	private final CategoryCommandToCategory categoryConverter;
	private final IngredientCommandToIngredient ingredientConverter;
	private final NotesCommandToNotes notesConverter;
	
	public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, 
			IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {

		this.categoryConverter = categoryConverter;
		this.ingredientConverter = ingredientConverter;
		this.notesConverter = notesConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public Recipe convert(RecipeCommand source) {

		if (source == null) {
			return null;
		}
		
		final Recipe recipe = new Recipe();
		recipe.setId(source.getId());
		recipe.setCookTime(source.getCookTime());
		recipe.setPrepTime(source.getPrepTime());
		recipe.setDescription(source.getDescription());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setDirections(source.getDirections());
		recipe.setSource(source.getSource());
		recipe.setServings(source.getServings());
		recipe.setUrl(source.getUrl());
		recipe.setNotes(notesConverter.convert(source.getNotes()));
		
		if (source.getCategories() != null && source.getCategories().size() > 0) {
			
			source.getCategories()
				.forEach((CategoryCommand categoryCmd) -> recipe.getCategories().add(categoryConverter.convert(categoryCmd)));
		}
		
		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			
			source.getIngredients()
				.forEach((IngredientCommand ingredientCmd) -> recipe.getIngredients().add(ingredientConverter.convert(ingredientCmd)));
		}
		
		return recipe;
	}
	
}
