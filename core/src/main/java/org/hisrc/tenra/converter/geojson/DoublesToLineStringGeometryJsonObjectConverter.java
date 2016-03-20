package org.hisrc.tenra.converter.geojson;

import java.util.List;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;

public class DoublesToLineStringGeometryJsonObjectConverter implements
		Converter<List<Double>, JsonObject> {

	public static final Converter<List<Double>, JsonObject> INSTANCE = new DoublesToLineStringGeometryJsonObjectConverter();

	@Override
	public JsonObject convert(List<Double> value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "LineString");
		builder.add("coordinates",
				DoublesToLineStringGeometryJsonArrayConverter.INSTANCE
						.convert(value));

		return builder.build();
	}

}
