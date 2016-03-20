package org.hisrc.tenra.converter.xml.bind;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class JAXBElementToValueConverter<S, T extends S, O> implements
		Converter<JAXBElement<? extends S>, O> {

	private final Converter<T, O> converter;
	private final QName name;
	private final Class<? extends S> theClass;

	public JAXBElementToValueConverter(Converter<T, O> converter,
			Class<? extends S> theClass, QName name) {
		Validate.notNull(converter);
		this.name = name;
		this.theClass = theClass;
		this.converter = converter;
	}

	@Override
	public O convert(JAXBElement<? extends S> value) {
		Ensure.propertyIsNotNull(value.getValue(), value, "value");
		if (this.name != null) {
			Ensure.propertyEquals(value.getName(), value, "name", this.name);
		}
		final S s = value.getValue();
		if (this.theClass != null) {
			Ensure.propertyIsInstanceOf(s, value, "value", this.theClass);
		}
		final T t = (T) s;
		return this.converter.convert(t);
	}

}
