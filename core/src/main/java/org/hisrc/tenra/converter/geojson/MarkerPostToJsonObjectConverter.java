package org.hisrc.tenra.converter.geojson;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.MarkerPost;

public class MarkerPostToJsonObjectConverter implements
		Converter<MarkerPost, JsonObject> {

	public static final Converter<MarkerPost, JsonObject> INSTANCE = new MarkerPostToJsonObjectConverter();

	@Override
	public JsonObject convert(MarkerPost value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "Feature");
		builder.add("geometry",
				DoublesToPointGeometryJsonObjectConverter.INSTANCE
						.convert(value.getCoordinates()));

		final JsonObjectBuilder properties = JsonProvider.provider()
				.createObjectBuilder();

		properties.add("id", value.getId());
		properties.add("railwayLineId", value.getRailwayLineId());
		properties.add("railwayLineCode", value.getRailwayLineCode());
		properties.add("railwayLineGeographicalName",
				value.getRailwayLineGeographicalName());
		properties.add("location", value.getLocation());

		builder.add("properties", properties);

		return builder.build();
	}
}
