package org.hisrc.tenra.converter.geojson;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.RailwayLine;
import org.hisrc.tenra.model.RailwayLink;

public class RailwayLineToJsonObjectConverter implements
		Converter<RailwayLine, JsonObject> {

	public static final Converter<RailwayLine, JsonObject> INSTANCE = new RailwayLineToJsonObjectConverter();

	@Override
	public JsonObject convert(RailwayLine value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "Feature");

		final JsonObjectBuilder properties = JsonProvider.provider()
				.createObjectBuilder();

		properties.add("id", value.getId());
		properties.add("geographicalName", value.getGeographicalName());
		properties.add("railwayLineCode", value.getRailwayLineCode());
		final JsonArrayBuilder railwayLinkIdsBuilder = JsonProvider.provider()
				.createArrayBuilder();
		for (String railwayLinkId : value.getRailwayLinkIds()) {
			railwayLinkIdsBuilder.add(railwayLinkId);
		}
		properties.add("railwayLinkIds", railwayLinkIdsBuilder.build());
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
