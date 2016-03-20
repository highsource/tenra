package org.hisrc.tenra.converter.gml.v_3_2_1;

import net.opengis.gml.v_3_2_1.CodeType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.util.Ensure;

public class CodeTypeToStringConverter implements Converter<CodeType, String> {

	public static final Converter<CodeType, String> INSTANCE = new CodeTypeToStringConverter();

	@Override
	public String convert(CodeType value) {
		Ensure.propertyIsNull(value.getCodeSpace(), value, "codeSpace");
		Ensure.propertyIsNotNull(value.getValue(), value, "value");
		return value.getValue().trim();
	}

}
