package org.hisrc.tenra.converter.geographicalnames._3;

import inspire.x.specification.gmlas.geographicalnames._3.SpellingOfNamePropertyType;
import inspire.x.specification.gmlas.geographicalnames._3.SpellingOfNameType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class SpellingOfNamePropertyTypeToStringConverter implements
		Converter<SpellingOfNamePropertyType, String> {

	public static final Converter<SpellingOfNamePropertyType, String> INSTANCE = new SpellingOfNamePropertyTypeToStringConverter();

	public String convert(SpellingOfNamePropertyType value) {
		SpellingOfNameType spellingOfName = value.getSpellingOfName();
		Ensure.propertyIsNotNull(spellingOfName, value, "spellingOfName");
		return SpellingOfNameTypeToStringConverter.INSTANCE
				.convert(spellingOfName);
	}
}
