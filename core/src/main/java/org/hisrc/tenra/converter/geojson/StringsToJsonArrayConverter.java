package org.hisrc.tenra.converter.geojson;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;

public class StringsToJsonArrayConverter implements
		Converter<Iterable<String>, JsonArray> {

	public static final Converter<Iterable<String>, JsonArray> INSTANCE = new StringsToJsonArrayConverter();

	@Override
	public JsonArray convert(Iterable<String> value) {
		final JsonArrayBuilder builder = JsonProvider.provider()
				.createArrayBuilder();
		for (String item : value) {
			builder.add(item);
		}
		return builder.build();
	}
}
