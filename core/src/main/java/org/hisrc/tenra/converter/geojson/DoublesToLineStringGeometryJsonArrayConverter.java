package org.hisrc.tenra.converter.geojson;

import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.spi.JsonProvider;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.Converter;

public class DoublesToLineStringGeometryJsonArrayConverter implements
		Converter<List<Double>, JsonArray> {

	public static final Converter<List<Double>, JsonArray> INSTANCE = new DoublesToLineStringGeometryJsonArrayConverter();

	@Override
	public JsonArray convert(List<Double> value) {
		Validate.noNullElements(value);
		Validate.isTrue((value.size() % 2) == 0);

		final JsonArrayBuilder builder = JsonProvider.provider()
				.createArrayBuilder();

		for (int index = 0; index < value.size(); index += 2) {
			builder.add(DoublesToPointGeometryJsonArrayConverter.INSTANCE
					.convert(value.subList(index, index + 2)));
		}
		return builder.build();
	}

}
