//package org.hisrc.tenra.converter.railwaytransportnetwork._3;
//
//import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayUseType;
//
//import org.apache.commons.lang3.Validate;
//import org.hisrc.tenra.converter.Converter;
//import org.hisrc.tenra.converter.basetypes._3.IdentifierPropertyTypeToStringConverter;
//import org.hisrc.tenra.converter.gml.v_3_2_1.CodeTypeToStringConverter;
//import org.hisrc.tenra.converter.gml.v_3_2_1.CodeWithAuthorityTypeToStringConverter;
//import org.hisrc.tenra.model.DBNetzConstants;
//import org.hisrc.tenra.model.RailwayLine;
//import org.hisrc.tenra.util.Ensure;
//
//public class RailwayUseTypeConverter implements
//		Converter<RailwayUseType, RailwayLine> {
//
//	public static final Converter<RailwayUseType, RailwayLine> INSTANCE = new RailwayUseTypeConverter();
//
//	@Override
//	public RailwayLine convert(RailwayUseType value) {
//		Validate.notNull(value);
//		Ensure.propertyIsNull(value.getBeginLifespanVersion(), value,
//				"beginLifespanVersion");
//		Ensure.propertyIsNull(value.getBoundedBy(), value, "boundedBy");
//		Ensure.propertyIsNull(value.getDescription(), value, "description");
//		Ensure.propertyIsNull(value.getDescriptionReference(), value,
//				"descriptionReference");
//		Ensure.propertyIsNull(value.getLocation(), value, "location");
//		Ensure.propertyIsNull(value.getValidFrom(), value, "validFrom");
//		Ensure.propertyIsNull(value.getValidTo(), value, "validTo");
//
//		Ensure.propertyIsEmpty(value.getMetaDataProperty(), value,
//				"metaDataProperty");
//		Ensure.propertyIsEmpty(value.getName(), value, "name");
//		Ensure.propertyIsNil(value.getEndLifespanVersion(), value,
//				"endLifespanVersion");
//		Ensure.propertyIsNotNull(value.getInspireId(), value, "inspireId");
//
//		// Ensure.propertyIsNotNull(value.getStartNode(), value, "startNode");
//		// Ensure.propertyIsNotNull(value.getEndNode(), value, "endNode");
////		Ensure.propertyIsNotNull(value.getInNetwork(), value, "inNetwork");
//
//		final String id = CodeWithAuthorityTypeToStringConverter.INSTANCE
//				.convert(value.getIdentifier());
//		Ensure.propertyStartsWith(id, value, "identifier",
//				DBNetzConstants.ID_PREFIX);
//		final String localId = IdentifierPropertyTypeToStringConverter.INSTANCE
//				.convert(value.getInspireId());
//		final String expectedLocalId = id.substring(DBNetzConstants.ID_PREFIX
//				.length());
//		Ensure.propertyEquals(value.getId(), value, "id", localId);
//		Ensure.propertyEquals(value.getId(), value, "id", expectedLocalId);
//		
//		value.getNetworkRef()
//		
//
//		Ensure.propertyIsNotNull(value.getUse(), value, "use");
//		final String use = CodeTypeToStringConverter.INSTANCE.convert(value.getUse());
//
//		return new RailwayLine(localId, geographicalName, code, linkIds);
//	}
//
//}
