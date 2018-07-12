package com.example.recipe.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.recipe.commands.UnitOfMeasureCommand;
import com.example.recipe.domain.UnitOfMeasure;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

	public static final Long ID_VALUE = new Long(1L);
	public static final String DESCRIPTION = "description";
	UnitOfMeasureCommandToUnitOfMeasure uomConverter;
	
	@Before
	public void setUp() throws Exception{
		
		uomConverter = new UnitOfMeasureCommandToUnitOfMeasure();
	}
	
	@Test
	public void testNullObject() throws Exception{
		
		assertNull(uomConverter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception{
		
		assertNotNull(uomConverter.convert(new  UnitOfMeasureCommand()));
	}
	
	@Test
	public void convert() throws Exception{
		
		UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(ID_VALUE);
		uomCommand.setDescription(DESCRIPTION);
		
		UnitOfMeasure uom = uomConverter.convert(uomCommand);
		
		assertEquals(ID_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());
	}
}
