package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import inspire.x.specification.gmlas.network._3.DirectedLinkPropertyType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLinkSequenceType;

import java.util.ArrayList;
import java.util.List;

import net.opengis.gml.v_3_2_1.ReferenceType;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.basetypes._3.IdentifierPropertyTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.CodeWithAuthorityTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.ReferenceTypeToStringConverter;
import org.hisrc.tenra.converter.network._3.DirectedLinkPropertyTypeToIdConverter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.model.RailwayLinkSequence;
import org.hisrc.tenra.util.Ensure;

public class RailwayLinkSequenceTypeConverter implements
		Converter<RailwayLinkSequenceType, RailwayLinkSequence> {

	public static final Converter<RailwayLinkSequenceType, RailwayLinkSequence> INSTANCE = new RailwayLinkSequenceTypeConverter();

	@Override
	public RailwayLinkSequence convert(RailwayLinkSequenceType value) {
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

		// Ensure.propertyIsNotNull(value.getStartNode(), value, "startNode");
		// Ensure.propertyIsNotNull(value.getEndNode(), value, "endNode");
		Ensure.propertyIsNotNull(value.getInNetwork(), value, "inNetwork");

		// final String geographicalName =
		// TransportLinkType_JAXBElement_GeographicalName_ToStringConverter.INSTANCE
		// .convert(value.getGeographicalName());
		final String id = CodeWithAuthorityTypeToStringConverter.INSTANCE
				.convert(value.getIdentifier());
		Ensure.propertyStartsWith(id, value, "identifier",
				DBNetzConstants.ID_COLON_PREFIX);
		final String localId = IdentifierPropertyTypeToStringConverter.INSTANCE
				.convert(value.getInspireId());
		final String expectedLocalId = id.substring(DBNetzConstants.ID_COLON_PREFIX
				.length());
		Ensure.propertyEquals(value.getId(), value, "id", localId);
		Ensure.propertyEquals(value.getId(), value, "id", expectedLocalId);

		final ReferenceType inNetwork = Ensure.propertyHasSingleItem(
				value.getInNetwork(), value, "inNetwork");
		final String inNetworkId = ReferenceTypeToStringConverter.INSTANCE
				.convert(inNetwork);

		Ensure.propertyIsNotEmpty(value.getLink(), value, "link");

		final List<String> railwayLinkIds = new ArrayList<>(value.getLink().size());
		for (final DirectedLinkPropertyType link : value.getLink()) {
			railwayLinkIds.add(DirectedLinkPropertyTypeToIdConverter.INSTANCE
					.convert(link));
		}

		return new RailwayLinkSequence(localId, railwayLinkIds);
	}

}
