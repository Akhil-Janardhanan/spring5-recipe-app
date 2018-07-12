package com.example.recipe.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.recipe.commands.NotesCommand;
import com.example.recipe.domain.Notes;

public class NotesToNotesCommandTest {

	public static final Long ID_VALUE = new Long(1L);
	public static final String RECIPE_NOTE = "notes";
	NotesToNotesCommand converter;
	
	@Before
	public void setUp() throws Exception{
		
		converter = new NotesToNotesCommand();
	}
	
	@Test
	public void testNullObject() throws Exception{
		
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception{
		
		assertNotNull(converter.convert(new Notes()));
	}
	
	@Test
	public void convert() throws Exception{
		
		Notes notes = new Notes();
		notes.setId(ID_VALUE);
		notes.setRecipeNotes(RECIPE_NOTE);
		
		NotesCommand command = converter.convert(notes);
		
		assertEquals(ID_VALUE, command.getId());
		assertEquals(RECIPE_NOTE, command.getRecipeNotes());
	}
}
