package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import inspire.x.specification.gmlas.network._3.LinkSetType.Link;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLineType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLineType.RailwayLineCode;

import java.util.ArrayList;
import java.util.List;

import net.opengis.gml.v_3_2_1.ReferenceType;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.basetypes._3.IdentifierPropertyTypeToStringConverter;
import org.hisrc.tenra.converter.geographicalnames._3.TransportLinkSetType_JAXBElement_GeographicalName_ToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.CodeWithAuthorityTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.ReferenceTypeToStringConverter;
import org.hisrc.tenra.converter.network._3.DirectedLinkPropertyTypeToIdConverter;
import org.hisrc.tenra.converter.network._3.LinkSetType_LinkToIdConverter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.model.RailwayLine;
import org.hisrc.tenra.model.RailwayLinkSequence;
import org.hisrc.tenra.util.Ensure;

public class RailwayLineTypeConverter implements
		Converter<RailwayLineType, RailwayLine> {

	public static final Converter<RailwayLineType, RailwayLine> INSTANCE = new RailwayLineTypeConverter();

	@Override
	public RailwayLine convert(RailwayLineType value) {
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
		Ensure.propertyIsNotNull(value.getGeographicalName(), value,
				"geographicalName");
		Ensure.propertyIsNotNull(value.getInspireId(), value, "inspireId");

		// Ensure.propertyIsNotNull(value.getStartNode(), value, "startNode");
		// Ensure.propertyIsNotNull(value.getEndNode(), value, "endNode");
		Ensure.propertyIsNotNull(value.getInNetwork(), value, "inNetwork");

		final String geographicalName = TransportLinkSetType_JAXBElement_GeographicalName_ToStringConverter.INSTANCE
				.convert(value.getGeographicalName());
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

		final List<String> linkIds = new ArrayList<>(value.getLink().size());
		for (final Link link : value.getLink()) {
			linkIds.add(LinkSetType_LinkToIdConverter.INSTANCE.convert(link));
		}
		Ensure.propertyIsNotNull(value.getRailwayLineCode(), value,
				"railwayLineCode");
		final RailwayLineCode railwayLineCode = value.getRailwayLineCode();
		final String code = RailwayLineCodeToIdConverter.INSTANCE
				.convert(railwayLineCode);

		return new RailwayLine(localId, geographicalName, code, linkIds);
	}

}
