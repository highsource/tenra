package org.hisrc.tenra.serializer;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.lang3.Validate;

public class MultipleSerializer<T> implements Serializer<T> {

	private Iterable<Serializer<T>> serializers;

	@SafeVarargs
	public MultipleSerializer(Serializer<T>... serializers) {
		Validate.noNullElements(serializers);
		this.serializers = Arrays.asList(serializers);
	}

	@Override
	public void start() throws IOException {
		for (Serializer<T> serializer : this.serializers) {
			serializer.start();
		}
	}

	@Override
	public void serialize(T value) throws IOException {
		for (Serializer<T> serializer : this.serializers) {
			serializer.serialize(value);
		}
	}

	@Override
	public void end() throws IOException {
		for (Serializer<T> serializer : this.serializers) {
			serializer.end();
		}
	}
}
