package org.hisrc.tenra.converter.geographicalnames._3;

import inspire.x.specification.gmlas.geographicalnames._3.GeographicalNameType;
import inspire.x.specification.gmlas.geographicalnames._3.SpellingOfNamePropertyType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class GeographicalNameTypeToStringConverter implements
		Converter<GeographicalNameType, String> {

	public static final Converter<GeographicalNameType, String> INSTANCE = new GeographicalNameTypeToStringConverter();

	public String convert(GeographicalNameType value) {
		Ensure.propertyIsNull(value.getLanguage(), value, "language");
		Ensure.propertyIsNull(value.getNativeness(), value, "nativeness");
		Ensure.propertyIsNull(value.getNameStatus(), value, "nameStatus");
		Ensure.propertyIsNull(value.getSourceOfName(), value, "sourceOfName");
		Ensure.propertyIsNull(value.getPronunciation(), value, "pronunciation");
		Ensure.propertyIsNil(value.getGrammaticalGender(), value,
				"grammaticalGender");
		Ensure.propertyIsNil(value.getGrammaticalNumber(), value,
				"grammaticalNumber");
		final SpellingOfNamePropertyType spelling = Ensure
				.propertyHasSingleItem(value.getSpelling(), value, "spelling");
		return SpellingOfNamePropertyTypeToStringConverter.INSTANCE
				.convert(spelling);
	}
}
