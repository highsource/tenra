package org.hisrc.tenra.converter.gml.v_3_2_1;

import java.util.List;

import net.opengis.gml.v_3_2_1.DirectPositionListType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class DirectPositionListTypeToDoublesConverter implements
		Converter<DirectPositionListType, List<Double>> {

	public static final Converter<DirectPositionListType, List<Double>> INSTANCE = new DirectPositionListTypeToDoublesConverter();

	@Override
	public List<Double> convert(DirectPositionListType value) {
		Ensure.propertyIsEmpty(value.getAxisLabels(), value, "axisLabels");
		Ensure.propertyIsEmpty(value.getUomLabels(), value, "uomLabels");
		Ensure.propertyIsNull(value.getSrsDimension(), value, "srsDimension");
		Ensure.propertyIsNull(value.getSrsName(), value, "srsName");
		Ensure.propertyIsNull(value.getCount(), value, "count");
		final List<Double> coordinates = value.getValue();
		Ensure.propertyIsNotEmpty(coordinates, value, "value");
		Ensure.propertyHasMultipleNumberOfItems(coordinates, value, "value", 2);
		Ensure.propertyHasNoNulls(coordinates, value, "value");
		return coordinates;
	}

}
