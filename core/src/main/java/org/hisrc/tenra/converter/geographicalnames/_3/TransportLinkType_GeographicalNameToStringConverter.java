package org.hisrc.tenra.converter.geographicalnames._3;

import inspire.x.specification.gmlas.commontransportelements._3.TransportLinkType.GeographicalName;
import inspire.x.specification.gmlas.geographicalnames._3.GeographicalNameType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class TransportLinkType_GeographicalNameToStringConverter implements
		Converter<GeographicalName, String> {

	public static final Converter<GeographicalName, String> INSTANCE = new TransportLinkType_GeographicalNameToStringConverter();

	public String convert(GeographicalName value) {
		GeographicalNameType geographicalName = value.getGeographicalName();
		Ensure.propertyIsNotNull(geographicalName, value, "geographicalName");
		return GeographicalNameTypeToStringConverter.INSTANCE
				.convert(geographicalName);
	}
}
