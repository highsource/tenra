package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayNodeType;

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
import org.hisrc.tenra.model.RailwayNode;
import org.hisrc.tenra.util.Ensure;

public class RailwayNodeTypeConverter implements
		Converter<RailwayNodeType, RailwayNode> {

	public static final Converter<RailwayNodeType, RailwayNode> INSTANCE = new RailwayNodeTypeConverter();

	public RailwayNode convert(RailwayNodeType value) {
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
		Ensure.propertyIsNotNull(value.getFormOfNode(), value, "formOfNode");
		// Ensure.propertyIsNil(value.getGeographicalName(), value,
		// "geographicalName");
		Ensure.propertyIsNotNull(value.getInspireId(), value, "inspireId");
		Ensure.propertyIsNotNull(value.getGeometry(), value, "geometry");

		final String formOfNode = FormOfNodeToStringConverter.INSTANCE
				.convert(value.getFormOfNode());
		final String geographicalName;
		if (value.getGeographicalName() != null
				&& !value.getGeographicalName().isNil()) {
			geographicalName = TransportNodeType_JAXBElement_GeographicalName_ToStringConverter.INSTANCE
					.convert(value.getGeographicalName());
		} else {
			geographicalName = null;
		}
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

		final ReferenceType inNetwork = Ensure.propertyHasSingleItem(
				value.getInNetwork(), value, "inNetwork");
		final String inNetworkId = ReferenceTypeToStringConverter.INSTANCE
				.convert(inNetwork);

		Ensure.propertyHasNoNulls(value.getSpokeStart(), value, "spokeStart");
		Ensure.propertyHasNoNulls(value.getSpokeEnd(), value, "spokeEnd");
		// TODO set?
		final List<String> spokeStart = new ArrayList<>(value.getSpokeStart()
				.size());
		for (ReferenceType reference : value.getSpokeStart()) {
			spokeStart.add(ReferenceTypeToStringConverter.INSTANCE
					.convert(reference));
		}
		final List<String> spokeEnd = new ArrayList<>(value.getSpokeEnd()
				.size());
		for (ReferenceType reference : value.getSpokeEnd()) {
			spokeEnd.add(ReferenceTypeToStringConverter.INSTANCE
					.convert(reference));
		}

		return new RailwayNode(localId, geographicalName, formOfNode,
				spokeStart, spokeEnd, coordinates);
	}
}
