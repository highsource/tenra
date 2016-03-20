package org.hisrc.tenra.converter.network._3;

import inspire.x.specification.gmlas.network._3.DirectedLinkPropertyType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class DirectedLinkPropertyTypeToIdConverter implements
		Converter<DirectedLinkPropertyType, String> {

	public static final Converter<DirectedLinkPropertyType, String> INSTANCE = new DirectedLinkPropertyTypeToIdConverter();

	@Override
	public String convert(DirectedLinkPropertyType value) {
		Ensure.propertyIsNotNull(value.getDirectedLink(), value, "directedLink");
		return DirectedLinkTypeToIdConverter.INSTANCE.convert(value
				.getDirectedLink());
	}
}
