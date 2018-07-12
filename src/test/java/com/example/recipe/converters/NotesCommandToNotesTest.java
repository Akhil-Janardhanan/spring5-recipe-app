package com.example.recipe.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.recipe.commands.NotesCommand;
import com.example.recipe.domain.Notes;

public class NotesCommandToNotesTest {

	public static final Long ID_VALUE = new Long(1L);
	public static final String RECIPE_NOTES = "Notes";
	NotesCommandToNotes converter;
	
	@Before
	public void setUp() throws Exception{
		
		converter = new NotesCommandToNotes();
	}
	
	@Test
	public void testNullObject() throws Exception{
		
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception{
		
		assertNotNull(converter.convert(new NotesCommand()));
	}
	
	@Test
	public void convert() throws Exception{
		
		NotesCommand command = new NotesCommand();
		command.setId(ID_VALUE);
		command.setRecipeNotes(RECIPE_NOTES);
		
		Notes notes = converter.convert(command);
		
		assertEquals(ID_VALUE, notes.getId());
		assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
	}
}
