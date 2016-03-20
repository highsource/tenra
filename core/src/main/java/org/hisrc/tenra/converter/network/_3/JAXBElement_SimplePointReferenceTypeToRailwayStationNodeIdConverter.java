package org.hisrc.tenra.converter.network._3;

import inspire.x.specification.gmlas.network._3.NetworkReferenceType;
import inspire.x.specification.gmlas.network._3.SimplePointReferenceType;

import javax.xml.bind.JAXBElement;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class JAXBElement_SimplePointReferenceTypeToRailwayStationNodeIdConverter
		implements
		Converter<JAXBElement<? extends NetworkReferenceType>, String> {

	public static final Converter<JAXBElement<? extends NetworkReferenceType>, String> INSTANCE = new JAXBElement_SimplePointReferenceTypeToRailwayStationNodeIdConverter();

	@Override
	public String convert(JAXBElement<? extends NetworkReferenceType> value) {
		final SimplePointReferenceType simplePointReference = Ensure
				.propertyIsInstanceOf(value.getValue(), value, "value",
						SimplePointReferenceType.class);
		return SimplePointReferenceTypeToRailwayStationNodeIdConverter.INSTANCE
				.convert(simplePointReference);
	}
}
