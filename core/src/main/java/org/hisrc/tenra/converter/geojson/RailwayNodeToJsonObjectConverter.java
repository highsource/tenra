package org.hisrc.tenra.converter.geojson;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.RailwayNode;

public class RailwayNodeToJsonObjectConverter implements
		Converter<RailwayNode, JsonObject> {

	public static final Converter<RailwayNode, JsonObject> INSTANCE = new RailwayNodeToJsonObjectConverter();

	@Override
	public JsonObject convert(RailwayNode value) {

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
		final String geographicalName = value.getGeographicalName();
		if (geographicalName != null) {
			properties.add("geographicalName", geographicalName);
		} else {
			properties.addNull("geographicalName");
		}
		properties.add("spokeStartIds", StringsToJsonArrayConverter.INSTANCE
				.convert(value.getSpokeStartIds()));

		properties.add("spokeEndIds", StringsToJsonArrayConverter.INSTANCE
				.convert(value.getSpokeEndIds()));

		builder.add("properties", properties);

		return builder.build();
	}
}
