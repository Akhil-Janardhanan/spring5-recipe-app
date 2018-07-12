package com.example.recipe.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.recipe.commands.UnitOfMeasureCommand;
import com.example.recipe.domain.UnitOfMeasure;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

	public static final Long ID_VALUE = new Long(1L);
	public static final String DESCRIPTION = "description";
	UnitOfMeasureToUnitOfMeasureCommand uomConverter;
	
	@Before
	public void setUp() throws Exception{
		
		uomConverter = new UnitOfMeasureToUnitOfMeasureCommand();
	}
	
	@Test
	public void testNullObjectConvert() throws Exception{
		
		assertNull(uomConverter.convert(null));;
	}
	
	@Test
	public void testEmptyObject() throws Exception{
		
		assertNotNull(uomConverter.convert(new UnitOfMeasure()));
	}
	
	@Test
	public void convert()throws Exception{
		
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(ID_VALUE);
		uom.setDescription(DESCRIPTION);
		
		UnitOfMeasureCommand uomCommand = uomConverter.convert(uom);
		
		assertEquals(ID_VALUE, uomCommand.getId());
		assertEquals(DESCRIPTION, uomCommand.getDescription());
	}
}
