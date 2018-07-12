package com.example.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.commands.UnitOfMeasureCommand;
import com.example.recipe.domain.UnitOfMeasure;

import lombok.Synchronized;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand>{

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure source) {

		if (source !=  null) {
			
			final UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
			uomCommand.setId(source.getId());
			uomCommand.setDescription(source.getDescription());
			return uomCommand;
		}
	
		return null;
	}

}
