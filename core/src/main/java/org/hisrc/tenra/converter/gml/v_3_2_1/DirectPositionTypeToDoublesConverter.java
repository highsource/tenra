package org.hisrc.tenra.converter.gml.v_3_2_1;

import java.util.List;

import net.opengis.gml.v_3_2_1.DirectPositionType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class DirectPositionTypeToDoublesConverter implements
		Converter<DirectPositionType, List<Double>> {

	public static final Converter<DirectPositionType, List<Double>> INSTANCE = new DirectPositionTypeToDoublesConverter();

	@Override
	public List<Double> convert(DirectPositionType value) {
		Ensure.propertyIsEmpty(value.getAxisLabels(), value, "axisLabels");
		Ensure.propertyIsEmpty(value.getUomLabels(), value, "uomLabels");
		Ensure.propertyIsNull(value.getSrsDimension(), value, "srsDimension");
		Ensure.propertyIsNull(value.getSrsName(), value, "srsName");
		final List<Double> coordinates = value.getValue();
		Ensure.propertyHasNumberOfItems(coordinates, value, "value", 2);
		Ensure.propertyHasNoNulls(coordinates, value, "value");
		return coordinates;
	}

}
