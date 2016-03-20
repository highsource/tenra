package org.hisrc.tenra.serializer.json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;

import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.json.stream.JsonGenerator;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.serializer.Serializer;

public class FeatureCollectionSerializer<T> implements Serializer<T> {

	private final File ouputFile;
	private final Converter<T, JsonObject> converter;

	public FeatureCollectionSerializer(Converter<T, JsonObject> converter, File ouputFile) {
		Validate.notNull(converter);
		Validate.notNull(ouputFile);
		this.converter = converter;
		this.ouputFile = ouputFile;
	}

	private OutputStream os;
	private JsonGenerator generator;

	@Override
	public void start() throws IOException {
		if (generator != null) {
			throw new IllegalStateException(
					"Invalid state, serializer was already started.");
		} else {
			os = new FileOutputStream(ouputFile);
			generator = JsonProvider
					.provider()
					.createGeneratorFactory(
							Collections.singletonMap(
									JsonGenerator.PRETTY_PRINTING, true))
					.createGenerator(os);

			generator.writeStartObject().write("type", "FeatureCollection")
					.writeStartArray("features");
		}
	}

	@Override
	public void end() throws IOException {
		if (generator == null) {
			throw new IllegalStateException(
					"Invalid state, serializer was not yet started.");
		} else {
			generator.writeEnd().writeEnd();
			generator.close();
			generator = null;
			os = null;
		}
	}

	@Override
	public void serialize(T value) throws IOException {
		if (generator == null) {
			throw new IllegalStateException(
					"Invalid state, serializer was not yet started.");
		} else {
			generator.write(converter.convert(value));
		}
	}
}
