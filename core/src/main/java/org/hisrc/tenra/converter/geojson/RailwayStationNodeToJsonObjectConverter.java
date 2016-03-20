package org.hisrc.tenra.converter.geojson;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.RailwayStationNode;

public class RailwayStationNodeToJsonObjectConverter implements
		Converter<RailwayStationNode, JsonObject> {

	public static final Converter<RailwayStationNode, JsonObject> INSTANCE = new RailwayStationNodeToJsonObjectConverter();

	@Override
	public JsonObject convert(RailwayStationNode value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "Feature");
		builder.add("geometry",
				DoublesToPointGeometryJsonObjectConverter.INSTANCE
						.convert(value.getCoordinates()));

		final JsonObjectBuilder properties = JsonProvider.provider()
				.createObjectBuilder();

		properties.add("id", value.getId());
		properties.add("formOfNode", value.getFormOfNode());
		properties.add("railwayStationCode", value.getRailwayStationCode()
				.getStationCode());
		properties.add("geographicalName", value.getGeographicalName());
		properties.add("spokeStartIds", StringsToJsonArrayConverter.INSTANCE
				.convert(value.getSpokeStartIds()));

		properties.add("spokeEndIds", StringsToJsonArrayConverter.INSTANCE
				.convert(value.getSpokeEndIds()));

		builder.add("properties", properties);

		return builder.build();
	}
}
