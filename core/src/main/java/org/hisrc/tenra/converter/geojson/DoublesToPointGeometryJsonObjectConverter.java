package org.hisrc.tenra.converter.geojson;

import java.util.List;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;

public class DoublesToPointGeometryJsonObjectConverter implements
		Converter<List<Double>, JsonObject> {

	public static final Converter<List<Double>, JsonObject> INSTANCE = new DoublesToPointGeometryJsonObjectConverter();

	@Override
	public JsonObject convert(List<Double> value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "Point");
		builder.add("coordinates",
				DoublesToPointGeometryJsonArrayConverter.INSTANCE
						.convert(value));

		return builder.build();
	}

}
