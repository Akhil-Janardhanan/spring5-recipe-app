package com.example.recipe.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.example.recipe.domain.Recipe;
import com.example.recipe.services.RecipeService;

public class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	@Mock
	IndexController indexController;
	
	@Before
	public void setUp()throws Exception{
		
		MockitoAnnotations.initMocks(this);
		
		indexController = new IndexController(recipeService);
	}
	
	@Test
	public void getIndexPage()throws Exception{
		
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		recipes.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);	
		
		String viewName = indexController.getIndexPage(model);
		
		assertEquals("index", viewName);
		
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}
}
