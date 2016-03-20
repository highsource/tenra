//package org.hisrc.tenra.converter.network._3;
//
//import inspire.x.specification.gmlas.network._3.NetworkPropertyType.NetworkRef;
//import inspire.x.specification.gmlas.network._3.NetworkReferenceType;
//
//import javax.xml.bind.JAXBElement;
//
//import org.hisrc.tenra.converter.Converter;
//import org.hisrc.tenra.model.RailwayLinkSequenceLinearReference;
//import org.hisrc.tenra.util.Ensure;
//
//public class NetworkRefToRailwayLinkSequenceLinearReferenceConverter implements
//		Converter<NetworkRef, RailwayLinkSequenceLinearReference> {
//
//	public static final Converter<NetworkRef, RailwayLinkSequenceLinearReference> INSTANCE = new NetworkRefToRailwayLinkSequenceLinearReferenceConverter();
//
//	@Override
//	public RailwayLinkSequenceLinearReference convert(NetworkRef value) {
//		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
//		final JAXBElement<? extends NetworkReferenceType> networkReference = value
//				.getNetworkReference();
//		Ensure.propertyIsNotNull(networkReference, value, "networkReference");
//		return JAXBElement_SimplePointReferenceTypeToRailwayStationNodeIdConverter.INSTANCE
//				.convert(networkReference);
//	}
//}
