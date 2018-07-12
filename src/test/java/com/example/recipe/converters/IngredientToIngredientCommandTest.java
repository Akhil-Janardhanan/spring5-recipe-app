package com.example.recipe.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.example.recipe.commands.IngredientCommand;
import com.example.recipe.domain.Ingredient;
import com.example.recipe.domain.Recipe;
import com.example.recipe.domain.UnitOfMeasure;

public class IngredientToIngredientCommandTest {

	public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = new Long(2L);
    public static final Long ID_VALUE = new Long(1L);
    
    IngredientToIngredientCommand converter;
    
    @Before
    public void setUp() throws Exception{
    	
    	converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }
    
    @Test
    public void testNullObject() throws Exception{
    	
    	assertNull(converter.convert(null));
    }
    
    @Test
    public void testEmptyObject() throws Exception{
    	
    	assertNotNull(converter.convert(new Ingredient()));
    }
    
    @Test
    public void testConvertNullUOM() throws Exception{
    	
    	Ingredient ingredient = new Ingredient();
    	ingredient.setId(ID_VALUE);
    	ingredient.setRecipe(RECIPE);
    	ingredient.setAmount(AMOUNT);
    	ingredient.setDescription(DESCRIPTION);
    	ingredient.setUom(null);
    	
    	IngredientCommand command = converter.convert(ingredient);
    	
    	assertNull(command.getUnitOfMeasure());
    	assertEquals(ID_VALUE, command.getId());
    	assertEquals(AMOUNT, command.getAmount());
    	assertEquals(DESCRIPTION, command.getDescription());
    }
    
    @Test
    public void testConvertWithUom() throws Exception{
    	
    	Ingredient ingredient = new Ingredient();
    	ingredient.setId(ID_VALUE);
    	ingredient.setRecipe(RECIPE);
    	ingredient.setAmount(AMOUNT);
    	ingredient.setDescription(DESCRIPTION);
    	
    	UnitOfMeasure uom = new UnitOfMeasure();
    	uom.setId(UOM_ID);
    	
    	ingredient.setUom(uom);
    	
    	IngredientCommand command = converter.convert(ingredient);
    	
    	assertNotNull(command.getUnitOfMeasure());
    	assertEquals(ID_VALUE, command.getId());
    	assertEquals(UOM_ID, command.getUnitOfMeasure().getId());
    	assertEquals(AMOUNT, command.getAmount());
    	assertEquals(DESCRIPTION, command.getDescription());
    }
}
