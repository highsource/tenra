package org.hisrc.tenra.converter.geojson;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.RailwayLink;

public class RailwayLinkToJsonObjectConverter implements
		Converter<RailwayLink, JsonObject> {

	public static final Converter<RailwayLink, JsonObject> INSTANCE = new RailwayLinkToJsonObjectConverter();

	@Override
	public JsonObject convert(RailwayLink value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "Feature");
		builder.add("geometry",
				DoublesToLineStringGeometryJsonObjectConverter.INSTANCE
						.convert(value.getCoordinates()));

		final JsonObjectBuilder properties = JsonProvider.provider()
				.createObjectBuilder();

		properties.add("id", value.getId());
		final String startNodeId = value.getStartNodeId();
		if (startNodeId != null) {
			properties.add("startNodeId", startNodeId);
		} else {
			properties.addNull("startNodeId");
		}
		final String endNodeId = value.getEndNodeId();
		if (endNodeId != null) {
			properties.add("endNodeId", endNodeId);
		} else {
			properties.addNull("endNodeId");
		}

		properties.add("railwayLineId", value.getRailwayLineId());
		properties.add("railwayLineCode", value.getRailwayLineCode());
		properties.add("railwayLineGeographicalName",
				value.getRailwayLineGeographicalName());

		properties.add("railwayLinkSequenceId", value.getRailwayLinkSequenceId());

		builder.add("properties", properties);

		return builder.build();
	}
}
