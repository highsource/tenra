package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLinkType;

import java.util.List;

import net.opengis.gml.v_3_2_1.ReferenceType;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.basetypes._3.IdentifierPropertyTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.CodeWithAuthorityTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.CurvePropertyTypeToDoublesConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.ReferenceTypeToStringConverter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.model.RailwayLink;
import org.hisrc.tenra.util.Ensure;

public class RailwayLinkTypeConverter implements
		Converter<RailwayLinkType, RailwayLink> {

	public static final Converter<RailwayLinkType, RailwayLink> INSTANCE = new RailwayLinkTypeConverter();

	@Override
	public RailwayLink convert(RailwayLinkType value) {
		Validate.notNull(value);
		Ensure.propertyIsNull(value.getBeginLifespanVersion(), value,
				"beginLifespanVersion");
		Ensure.propertyIsNull(value.getBoundedBy(), value, "boundedBy");
		Ensure.propertyIsNull(value.getDescription(), value, "description");
		Ensure.propertyIsNull(value.getDescriptionReference(), value,
				"descriptionReference");
		Ensure.propertyIsNull(value.getLocation(), value, "location");
		Ensure.propertyIsNull(value.getValidFrom(), value, "validFrom");
		Ensure.propertyIsNull(value.getValidTo(), value, "validTo");

		Ensure.propertyIsEmpty(value.getMetaDataProperty(), value,
				"metaDataProperty");
		Ensure.propertyIsEmpty(value.getName(), value, "name");
		Ensure.propertyIsNil(value.getEndLifespanVersion(), value,
				"endLifespanVersion");
		Ensure.propertyIsNull(value.getGeographicalName(), value,
				"geographicalName");
		Ensure.propertyIsNotNull(value.getInspireId(), value, "inspireId");
		Ensure.propertyIsNotNull(value.getCentrelineGeometry(), value,
				"centrelineGeometry");

		Ensure.propertyIsNotNull(value.getStartNode(), value, "startNode");
		Ensure.propertyIsNotNull(value.getEndNode(), value, "endNode");
		Ensure.propertyIsNotNull(value.getInNetwork(), value, "inNetwork");

		// final String geographicalName =
		// TransportLinkType_JAXBElement_GeographicalName_ToStringConverter.INSTANCE
		// .convert(value.getGeographicalName());
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

		final List<Double> coordinates = CurvePropertyTypeToDoublesConverter.INSTANCE
				.convert(value.getCentrelineGeometry());

		final ReferenceType inNetwork = Ensure.propertyHasSingleItem(
				value.getInNetwork(), value, "inNetwork");
		final String inNetworkId = ReferenceTypeToStringConverter.INSTANCE
				.convert(inNetwork);

		final String startNodeId = ReferenceTypeToStringConverter.INSTANCE
				.convert(value.getStartNode());
		final String endNodeId = ReferenceTypeToStringConverter.INSTANCE
				.convert(value.getEndNode());

		Ensure.propertyEquals(value.isFictitious(), value, "fictitious", false);

		return new RailwayLink(localId, startNodeId, endNodeId, coordinates);
	}

}
