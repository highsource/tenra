package org.hisrc.tenra.converter;

public interface Converter<I, O> {

	public O convert(I value);

}
