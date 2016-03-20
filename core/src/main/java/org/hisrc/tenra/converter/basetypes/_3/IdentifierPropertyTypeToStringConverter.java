package org.hisrc.tenra.converter.basetypes._3;

import inspire.x.specification.gmlas.basetypes._3.IdentifierPropertyType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class IdentifierPropertyTypeToStringConverter implements
		Converter<IdentifierPropertyType, String> {
	
	public static final Converter<IdentifierPropertyType, String> INSTANCE = new IdentifierPropertyTypeToStringConverter(); 

	@Override
	public String convert(IdentifierPropertyType value) {
		Ensure.propertyIsNotNull(value.getIdentifier(), value, "identifier");
		return IdentifierTypeToStringConverter.INSTANCE.convert(value.getIdentifier());
	}

}
