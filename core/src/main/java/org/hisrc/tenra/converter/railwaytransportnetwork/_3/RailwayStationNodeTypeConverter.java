package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayStationNodeType;

import java.util.ArrayList;
import java.util.List;

import net.opengis.gml.v_3_2_1.ReferenceType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.basetypes._3.IdentifierPropertyTypeToStringConverter;
import org.hisrc.tenra.converter.geographicalnames._3.TransportNodeType_JAXBElement_GeographicalName_ToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.CodeWithAuthorityTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.PointPropertyTypeToDoublesConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.ReferenceTypeToStringConverter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.model.RailwayStationNode;
import org.hisrc.tenra.util.Ensure;

public class RailwayStationNodeTypeConverter implements
		Converter<RailwayStationNodeType, RailwayStationNode> {

	public static final RailwayStationNodeTypeConverter INSTANCE = new RailwayStationNodeTypeConverter();

	public RailwayStationNode convert(RailwayStationNodeType value) {
		Ensure.propertyIsNull(value.getBeginLifespanVersion(), value,
				"beginLifespanVersion");
		Ensure.propertyIsNull(value.getBoundedBy(), value, "boundedBy");
		Ensure.propertyIsNull(value.getDescription(), value, "description");
		Ensure.propertyIsNull(value.getDescriptionReference(), value,
				"descriptionReference");
		Ensure.propertyIsNull(value.getLocation(), value, "location");
		Ensure.propertyIsNull(value.getNumberOfPlatforms(), value,
				"numberOfPlatforms");
		Ensure.propertyIsNull(value.getValidFrom(), value, "validFrom");
		Ensure.propertyIsNull(value.getValidTo(), value, "validTo");

		Ensure.propertyIsEmpty(value.getMetaDataProperty(), value,
				"metaDataProperty");
		Ensure.propertyIsEmpty(value.getName(), value, "name");
		Ensure.propertyIsNil(value.getEndLifespanVersion(), value,
				"endLifespanVersion");
		Ensure.propertyIsNotNull(value.getFormOfNode(), value, "formOfNode");
		Ensure.propertyIsNotNull(value.getGeographicalName(), value,
				"geographicalName");
		Ensure.propertyIsNotNull(value.getInspireId(), value, "inspireId");
		Ensure.propertyIsNotNull(value.getGeometry(), value, "geometry");

		final String formOfNode = FormOfNodeToStringConverter.INSTANCE
				.convert(value.getFormOfNode());
		final String geographicalName = TransportNodeType_JAXBElement_GeographicalName_ToStringConverter.INSTANCE
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

		final List<Double> coordinates = PointPropertyTypeToDoublesConverter.INSTANCE
				.convert(value.getGeometry());

		final double x = coordinates.get(0);
		final double y = coordinates.get(1);

		final ReferenceType inNetwork = Ensure.propertyHasSingleItem(
				value.getInNetwork(), value, "inNetwork");
		final String inNetworkId = ReferenceTypeToStringConverter.INSTANCE
				.convert(inNetwork);

		Ensure.propertyHasNoNulls(value.getSpokeStart(), value, "spokeStart");
		Ensure.propertyHasNoNulls(value.getSpokeEnd(), value, "spokeEnd");
		// TODO set?
		final List<String> spokeStartIds = new ArrayList<>(value.getSpokeStart()
				.size());
		for (ReferenceType reference : value.getSpokeStart()) {
			spokeStartIds.add(ReferenceTypeToStringConverter.INSTANCE
					.convert(reference));
		}
		final List<String> spokeEndIds = new ArrayList<>(value.getSpokeEnd()
				.size());
		for (ReferenceType reference : value.getSpokeEnd()) {
			spokeEndIds.add(ReferenceTypeToStringConverter.INSTANCE
					.convert(reference));
		}

		return new RailwayStationNode(localId, 
				geographicalName, formOfNode, spokeStartIds, spokeEndIds, coordinates);
	}
}
