package org.hisrc.tenra.converter.network._3;

import inspire.x.specification.gmlas.network._3.DirectedLinkType;
import net.opengis.gml.v_3_2_1.SignType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.gml.v_3_2_1.ReferenceTypeToStringConverter;
import org.hisrc.tenra.util.Ensure;

public class DirectedLinkTypeToIdConverter implements
		Converter<DirectedLinkType, String> {

	public static final Converter<DirectedLinkType, String> INSTANCE = new DirectedLinkTypeToIdConverter();

	@Override
	public String convert(DirectedLinkType value) {
		Ensure.propertyEquals(value.getDirection(), value, "direction",
				SignType.VALUE_2);
		Ensure.propertyIsNotNull(value.getLink(), value, "link");
		return ReferenceTypeToStringConverter.INSTANCE.convert(value.getLink());
	}
}
