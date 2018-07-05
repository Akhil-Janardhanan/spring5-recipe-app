package com.example.recipe.controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
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
		
		String viewName = indexController.getIndexPage(model);
		
		assertEquals("index", viewName);
		
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute("recipes", recipeService.getRecipes());
	}
}
