package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLineType.RailwayLineCode;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class RailwayLineCodeToIdConverter implements
		Converter<RailwayLineCode, String> {

	public static final Converter<RailwayLineCode, String> INSTANCE = new RailwayLineCodeToIdConverter();

	@Override
	public String convert(RailwayLineCode value) {
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		Ensure.propertyIsNotNull(value.getValue(), value, "value");
		return value.getValue().trim();
	}
}
