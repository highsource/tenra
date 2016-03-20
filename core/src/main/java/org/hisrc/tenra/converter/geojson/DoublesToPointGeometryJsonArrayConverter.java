package org.hisrc.tenra.converter.geojson;

import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.spi.JsonProvider;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.Converter;

public class DoublesToPointGeometryJsonArrayConverter implements
		Converter<List<Double>, JsonArray> {

	public static final Converter<List<Double>, JsonArray> INSTANCE = new DoublesToPointGeometryJsonArrayConverter();

	@Override
	public JsonArray convert(List<Double> value) {
		Validate.noNullElements(value);
		Validate.isTrue(value.size() == 2);
		final JsonArrayBuilder builder = JsonProvider.provider()
				.createArrayBuilder();
		builder.add(value.get(1));
		builder.add(value.get(0));
		return builder.build();
	}

}
