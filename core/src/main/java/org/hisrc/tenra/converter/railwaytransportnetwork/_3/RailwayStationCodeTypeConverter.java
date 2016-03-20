package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import inspire.x.specification.gmlas.network._3.NetworkPropertyType.NetworkRef;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayStationCodeType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.basetypes._3.IdentifierPropertyTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.CodeWithAuthorityTypeToStringConverter;
import org.hisrc.tenra.converter.network._3.NetworkRefToRailwayStationNodeIdConverter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.model.RailwayStationCode;
import org.hisrc.tenra.util.Ensure;

public class RailwayStationCodeTypeConverter implements
		Converter<RailwayStationCodeType, RailwayStationCode> {

	public static final RailwayStationCodeTypeConverter INSTANCE = new RailwayStationCodeTypeConverter();

	public RailwayStationCode convert(RailwayStationCodeType value) {
		Ensure.propertyIsNull(value.getBeginLifespanVersion(), value,
				"beginLifespanVersion");
		Ensure.propertyIsNull(value.getBoundedBy(), value, "boundedBy");
		Ensure.propertyIsNull(value.getDescription(), value, "description");
		Ensure.propertyIsNull(value.getDescriptionReference(), value,
				"descriptionReference");
		Ensure.propertyIsNull(value.getLocation(), value, "location");
		Ensure.propertyIsNull(value.getValidFrom(), value, "validFrom");
		Ensure.propertyIsNil(value.getValidTo(), value, "validTo");

		Ensure.propertyIsEmpty(value.getMetaDataProperty(), value,
				"metaDataProperty");
		Ensure.propertyIsEmpty(value.getName(), value, "name");
		Ensure.propertyIsNil(value.getEndLifespanVersion(), value,
				"endLifespanVersion");
		Ensure.propertyIsNotNull(value.getInspireId(), value, "inspireId");

		final NetworkRef networkRef = Ensure.propertyHasSingleItem(
				value.getNetworkRef(), value, "networkRef");

		final String railwayStationNodeId = NetworkRefToRailwayStationNodeIdConverter.INSTANCE
				.convert(networkRef);

		final String id = CodeWithAuthorityTypeToStringConverter.INSTANCE
				.convert(value.getIdentifier());
		Ensure.propertyStartsWith(id, value, "identifier",
				DBNetzConstants.ID_PREFIX);
		final String localId = IdentifierPropertyTypeToStringConverter.INSTANCE
				.convert(value.getInspireId());
		final String expectedLocalId = id.substring(DBNetzConstants.ID_PREFIX
				.length());
		Ensure.propertyEquals(value.getId(), value, "id", localId);
		Ensure.propertyEquals(value.getId(), value, "id", expectedLocalId);

		Ensure.propertyIsNotNull(value.getStationCode(), value, "stationCode");
		final String stationCode = value.getStationCode().trim();

		return new RailwayStationCode(localId, railwayStationNodeId,
				stationCode);
	}
}
