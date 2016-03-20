package org.hisrc.tenra.converter.gml.v_3_2_1;

import java.util.List;

import javax.xml.bind.JAXBElement;

import net.opengis.gml.v_3_2_1.AbstractCurveType;
import net.opengis.gml.v_3_2_1.CurvePropertyType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class CurvePropertyTypeToDoublesConverter implements
		Converter<CurvePropertyType, List<Double>> {

	public static final Converter<CurvePropertyType, List<Double>> INSTANCE = new CurvePropertyTypeToDoublesConverter();

	@Override
	public List<Double> convert(CurvePropertyType value) {
		Ensure.propertyIsNull(value.getActuate(), value, "actuate");
		Ensure.propertyIsNull(value.getArcrole(), value, "arcrole");
		Ensure.propertyIsNull(value.getHref(), value, "href");
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		Ensure.propertyIsNull(value.getRemoteSchema(), value, "remoteSchema");
		Ensure.propertyIsNull(value.getRole(), value, "role");
		Ensure.propertyIsNull(value.getShow(), value, "show");
		Ensure.propertyIsNull(value.getTitle(), value, "title");
		Ensure.propertyIsNull(value.getTYPE(), value, "type");
		Ensure.propertyIsNotNull(value.getAbstractCurve(), value,
				"abstractCurve");
		final JAXBElement<? extends AbstractCurveType> abstractCurve = value
				.getAbstractCurve();
		return LineStringTypeToDoublesConverter.JAXB_ELEMENT_CONVERTER_INSTANCE
				.convert(abstractCurve);
	}

}
