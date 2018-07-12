package com.example.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.domain.Category;
import com.example.recipe.domain.Ingredient;
import com.example.recipe.domain.Recipe;

import lombok.Synchronized;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{

	private final CategoryToCategoryCommand categoryConverter;
	private final IngredientToIngredientCommand ingredientConverter;
	private final NotesToNotesCommand notesConverter;
	
	public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, 
			IngredientToIngredientCommand ingredientConverter, NotesToNotesCommand notesConverter) {

		this.categoryConverter = categoryConverter;
		this.ingredientConverter = ingredientConverter;
		this.notesConverter = notesConverter;
	}
	
	@Synchronized
	@Nullable
	@Override
	public RecipeCommand convert(Recipe source) {

		if (source == null) {
			return null;
		}
		
		final RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(source.getId());
		recipeCommand.setCookTime(source.getCookTime());
		recipeCommand.setPrepTime(source.getPrepTime());
		recipeCommand.setServings(source.getServings());
		recipeCommand.setDifficulty(source.getDifficulty());
		recipeCommand.setDescription(source.getDescription());
		recipeCommand.setDirections(source.getDirections());
		recipeCommand.setSource(source.getSource());
		recipeCommand.setUrl(source.getUrl());
		recipeCommand.setNotes(notesConverter.convert(source.getNotes()));
		
		if (source.getCategories() != null && source.getCategories().size() > 0) {
			
			source.getCategories()
				.forEach((Category category) -> recipeCommand.getCategories().add(categoryConverter.convert(category)));
		}
		
		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			
			source.getIngredients()
				.forEach((Ingredient ingredient) -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
		}
		
		return recipeCommand;
	}

}
