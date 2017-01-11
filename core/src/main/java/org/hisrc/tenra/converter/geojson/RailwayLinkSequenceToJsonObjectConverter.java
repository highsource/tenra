package org.hisrc.tenra.converter.geojson;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.RailwayLink;
import org.hisrc.tenra.model.RailwayLinkSequence;

public class RailwayLinkSequenceToJsonObjectConverter implements
		Converter<RailwayLinkSequence, JsonObject> {

	public static final Converter<RailwayLinkSequence, JsonObject> INSTANCE = new RailwayLinkSequenceToJsonObjectConverter();

	@Override
	public JsonObject convert(RailwayLinkSequence value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "Feature");

		final JsonObjectBuilder properties = JsonProvider.provider()
				.createObjectBuilder();

		properties.add("id", value.getId());
		final JsonArrayBuilder railwayLinkIdsBuilder = JsonProvider.provider()
				.createArrayBuilder();
		for (String railwayLinkId : value.getRailwayLinkIds()) {
			railwayLinkIdsBuilder.add(railwayLinkId);
		}
		properties.add("linkIds", railwayLinkIdsBuilder.build());
		properties.add("lineId", value.getRailwayLineId());
		properties.add("lineCode", value.getRailwayLineCode());
		properties.add("lineName",
				value.getRailwayLineGeographicalName());

		
		builder.add("properties", properties);

		JsonObjectBuilder geometryBuilder = JsonProvider.provider()
				.createObjectBuilder();
		geometryBuilder.add("type", "MultiLineString");
		JsonArrayBuilder coordinatesBuilder = JsonProvider.provider()
				.createArrayBuilder();
		for (RailwayLink railwayLink : value.getRailwayLinks()) {
			coordinatesBuilder
					.add(DoublesToLineStringGeometryJsonArrayConverter.INSTANCE
							.convert(railwayLink.getCoordinates()));
		}
		geometryBuilder.add("coordinates", coordinatesBuilder.build());

		builder.add("geometry", geometryBuilder.build());
		return builder.build();
	}
}
