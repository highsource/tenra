package org.hisrc.tenra.converter.network._3;

import inspire.x.specification.gmlas.network._3.SimplePointReferenceType;
import net.opengis.gml.v_3_2_1.LengthType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.gml.v_3_2_1.LengthTypeToDoubleConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.ReferenceTypeToStringConverter;
import org.hisrc.tenra.util.Ensure;

public class SimplePointReferenceTypeToRailwayStationNodeIdConverter implements
		Converter<SimplePointReferenceType, String> {

	public static final Converter<SimplePointReferenceType, String> INSTANCE = new SimplePointReferenceTypeToRailwayStationNodeIdConverter();

	@Override
	public String convert(SimplePointReferenceType value) {
		Ensure.propertyIsNull(value.getApplicableDirection(), value,
				"applicableDirection");
		Ensure.propertyIsNull(value.getOffset(), value, "offset");
		Ensure.propertyIsNotNull(value.getAtPosition(), value, "atPosition");
		Ensure.propertyIsNotNull(value.getElement(), value, "element");
		final String railwayStationNodeId = ReferenceTypeToStringConverter.INSTANCE
				.convert(value.getElement());
		final LengthType atPosition = value.getAtPosition();
		final Double atPositionValue = LengthTypeToDoubleConverter.INSTANCE
				.convert(atPosition);
		Ensure.propertyEquals(atPositionValue, value, "atPosition.value", 0d);
		return railwayStationNodeId;
	}
}
