package org.hisrc.tenra.converter.gml.v_3_2_1;

import net.opengis.gml.v_3_2_1.CodeWithAuthorityType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.InspireContsants;
import org.hisrc.tenra.util.Ensure;

public class CodeWithAuthorityTypeToStringConverter implements
		Converter<CodeWithAuthorityType, String> {

	public static final Converter<CodeWithAuthorityType, String> INSTANCE = new CodeWithAuthorityTypeToStringConverter();

	public String convert(CodeWithAuthorityType value) {
		Ensure.propertyEquals(value.getCodeSpace(), value, "codeSpace",
				InspireContsants.CODESPACE_URI);
		final String code = value.getValue();
		Ensure.propertyIsNotNull(code, value, "value");
		return code.trim();
	}
}
