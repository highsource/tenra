package org.hisrc.tenra.converter.gml.v_3_2_1;

import java.math.BigInteger;
import java.util.List;

import net.opengis.gml.v_3_2_1.PointType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.util.Ensure;

public class PointTypeToDoublesConverter implements
		Converter<PointType, List<Double>> {

	public static final Converter<PointType, List<Double>> INSTANCE = new PointTypeToDoublesConverter();

	@Override
	public List<Double> convert(PointType value) {
		Ensure.propertyIsEmpty(value.getAxisLabels(), value, "axisLabels");
		Ensure.propertyIsEmpty(value.getMetaDataProperty(), value,
				"metaDataProperty");
		Ensure.propertyIsEmpty(value.getName(), value, "name");
		Ensure.propertyIsEmpty(value.getUomLabels(), value, "uomLabels");
		Ensure.propertyIsNull(value.getCoordinates(), value, "coordinates");
		Ensure.propertyIsNull(value.getDescription(), value, "description");
		Ensure.propertyIsNull(value.getDescriptionReference(), value,
				"descriptionReference");
		Ensure.propertyIsNotNull(value.getId(), value, "id");
		Ensure.propertyIsNull(value.getIdentifier(), value, "identifier");
		Ensure.propertyIsNotNull(value.getPos(), value, "pos");
		Ensure.propertyEquals(value.getSrsDimension(), value, "srsDimension",
				BigInteger.valueOf(2));
		Ensure.propertyEquals(value.getSrsName(), value, "srsName",
				DBNetzConstants.SRS_NAME);
		return DirectPositionTypeToDoublesConverter.INSTANCE.convert(value
				.getPos());
	}

}
