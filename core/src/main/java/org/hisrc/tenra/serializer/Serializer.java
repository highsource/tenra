package org.hisrc.tenra.serializer;

import java.io.IOException;

public interface Serializer<T> {

	public void start() throws IOException;
	public void serialize(T value) throws IOException;
	public void end() throws IOException;
}
