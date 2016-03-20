package org.hisrc.tenra.converter.gml.v_3_2_1;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import net.opengis.gml.v_3_2_1.AbstractCurveType;
import net.opengis.gml.v_3_2_1.LineStringType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.xml.bind.JAXBElementToValueConverter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.util.Ensure;

public class LineStringTypeToDoublesConverter implements
		Converter<LineStringType, List<Double>> {

	public static final Converter<LineStringType, List<Double>> INSTANCE = new LineStringTypeToDoublesConverter();

	public static final Converter<JAXBElement<? extends AbstractCurveType>, List<Double>> JAXB_ELEMENT_CONVERTER_INSTANCE = new JAXBElementToValueConverter<AbstractCurveType, LineStringType, List<Double>>(
			INSTANCE, LineStringType.class, GMLConstants.LINE_STRING_QNAME);

	@Override
	public List<Double> convert(LineStringType value) {
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
		Ensure.propertyEquals(value.getSrsDimension(), value, "srsDimension",
				BigInteger.valueOf(2));
		Ensure.propertyEquals(value.getSrsName(), value, "srsName",
				DBNetzConstants.SRS_NAME);
		Ensure.propertyIsEmpty(value.getPosOrPointPropertyOrPointRep(), value,
				"posOrPointPropertyOrPointRep");
		Ensure.propertyIsNotNull(value.getPosList(), value, "posList");
		return DirectPositionListTypeToDoublesConverter.INSTANCE.convert(value
				.getPosList());
	}

}
