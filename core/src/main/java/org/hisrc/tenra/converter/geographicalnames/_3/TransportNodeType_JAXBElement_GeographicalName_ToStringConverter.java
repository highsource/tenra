package org.hisrc.tenra.converter.geographicalnames._3;

import inspire.x.specification.gmlas.commontransportelements._3.TransportNodeType.GeographicalName;

import javax.xml.bind.JAXBElement;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class TransportNodeType_JAXBElement_GeographicalName_ToStringConverter
		implements Converter<JAXBElement<GeographicalName>, String> {

	public static final Converter<JAXBElement<GeographicalName>, String> INSTANCE = new TransportNodeType_JAXBElement_GeographicalName_ToStringConverter();

	public String convert(JAXBElement<GeographicalName> value) {
		final GeographicalName geographicalName = value.getValue();
		Ensure.propertyIsNotNull(geographicalName, value, "value");
		return TransportNodeType_GeographicalNameToStringConverter.INSTANCE
				.convert(geographicalName);
	}
}
