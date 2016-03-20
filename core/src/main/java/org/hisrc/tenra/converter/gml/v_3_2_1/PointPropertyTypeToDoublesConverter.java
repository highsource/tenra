package org.hisrc.tenra.converter.gml.v_3_2_1;

import java.util.List;

import net.opengis.gml.v_3_2_1.PointPropertyType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class PointPropertyTypeToDoublesConverter implements
		Converter<PointPropertyType, List<Double>> {
	
	public static final Converter<PointPropertyType, List<Double>> INSTANCE = new PointPropertyTypeToDoublesConverter();

	@Override
	public List<Double> convert(PointPropertyType value) {
		Ensure.propertyIsNull(value.getActuate(), value, "actuate");
		Ensure.propertyIsNull(value.getArcrole(), value, "arcrole");
		Ensure.propertyIsNull(value.getHref(), value, "href");
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		Ensure.propertyIsNull(value.getRemoteSchema(), value, "remoteSchema");
		Ensure.propertyIsNull(value.getRole(), value, "role");
		Ensure.propertyIsNull(value.getShow(), value, "show");
		Ensure.propertyIsNull(value.getTitle(), value, "title");
		Ensure.propertyIsNull(value.getTYPE(), value, "type");
		Ensure.propertyIsNotNull(value.getPoint(), value, "point");
		return PointTypeToDoublesConverter.INSTANCE.convert(value.getPoint());
	}

}
