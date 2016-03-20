package org.hisrc.tenra.converter.geographicalnames._3;

import inspire.x.specification.gmlas.geographicalnames._3.SpellingOfNameType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class SpellingOfNameTypeToStringConverter implements
		Converter<SpellingOfNameType, String> {

	public static final Converter<SpellingOfNameType, String> INSTANCE = new SpellingOfNameTypeToStringConverter();

	public String convert(SpellingOfNameType value) {
		Ensure.propertyIsNil(value.getTransliterationScheme(), value,
				"transliterationScheme");
		Ensure.propertyIsNull(value.getScript(), value, "script");
		final String text = value.getText();
		Ensure.propertyIsNotNull(text, value, "text");
		return text.trim();
	}
}
