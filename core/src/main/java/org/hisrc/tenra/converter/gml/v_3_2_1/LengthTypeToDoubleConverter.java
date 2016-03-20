package org.hisrc.tenra.converter.gml.v_3_2_1;

import net.opengis.gml.v_3_2_1.LengthType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.util.Ensure;

public class LengthTypeToDoubleConverter implements
		Converter<LengthType, Double> {

	public static final Converter<LengthType, Double> INSTANCE = new LengthTypeToDoubleConverter();

	@Override
	public Double convert(LengthType value) {
		Ensure.propertyEquals(value.getUom(), value, "uom", DBNetzConstants.UOM_KM);
		Ensure.propertyIsFiniteNumber(value.getValue(), value, "value");
		return value.getValue();
	}

}
