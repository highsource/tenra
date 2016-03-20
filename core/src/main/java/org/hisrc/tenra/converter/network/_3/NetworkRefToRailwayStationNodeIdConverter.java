package org.hisrc.tenra.converter.network._3;

import javax.xml.bind.JAXBElement;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

import inspire.x.specification.gmlas.network._3.NetworkPropertyType.NetworkRef;
import inspire.x.specification.gmlas.network._3.NetworkReferenceType;

public class NetworkRefToRailwayStationNodeIdConverter implements
		Converter<NetworkRef, String> {

	public static final Converter<NetworkRef, String> INSTANCE = new NetworkRefToRailwayStationNodeIdConverter();

	@Override
	public String convert(NetworkRef value) {
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		final JAXBElement<? extends NetworkReferenceType> networkReference = value
				.getNetworkReference();
		Ensure.propertyIsNotNull(networkReference, value, "networkReference");
		return JAXBElement_SimplePointReferenceTypeToRailwayStationNodeIdConverter.INSTANCE
				.convert(networkReference);
	}
}
