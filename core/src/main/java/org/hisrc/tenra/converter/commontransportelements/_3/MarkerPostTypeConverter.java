package org.hisrc.tenra.converter.commontransportelements._3;

import inspire.x.specification.gmlas.commontransportelements._3.MarkerPostType;

import java.util.List;

import net.opengis.gml.v_3_2_1.ReferenceType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.converter.basetypes._3.IdentifierPropertyTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.CodeWithAuthorityTypeToStringConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.LengthTypeToDoubleConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.PointPropertyTypeToDoublesConverter;
import org.hisrc.tenra.converter.gml.v_3_2_1.ReferenceTypeToStringConverter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.model.MarkerPost;
import org.hisrc.tenra.util.Ensure;

public class MarkerPostTypeConverter implements
		Converter<MarkerPostType, MarkerPost> {

	public static final Converter<MarkerPostType, MarkerPost> INSTANCE = new MarkerPostTypeConverter();

	public MarkerPost convert(MarkerPostType value) {
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
		Ensure.propertyIsNotNull(value.getGeometry(), value, "geometry");

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

		final String railwayLineId;
		if (value.getRoute() != null) {
			railwayLineId = ReferenceTypeToStringConverter.INSTANCE
					.convert(value.getRoute());
		} else {
			railwayLineId = null;
		}

		Ensure.propertyIsNotNull(value.getMarkerLocation(), value,
				"markerLocation");

		final Double location = LengthTypeToDoubleConverter.INSTANCE
				.convert(value.getMarkerLocation());

		return new MarkerPost(localId, railwayLineId, location, coordinates);
	}
}
