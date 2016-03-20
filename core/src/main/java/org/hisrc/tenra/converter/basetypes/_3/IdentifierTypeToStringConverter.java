package org.hisrc.tenra.converter.basetypes._3;

import inspire.x.specification.gmlas.basetypes._3.IdentifierType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.util.Ensure;

public class IdentifierTypeToStringConverter implements
		Converter<IdentifierType, String> {

	public static final Converter<IdentifierType, String> INSTANCE = new IdentifierTypeToStringConverter();

	@Override
	public String convert(IdentifierType value) {
		Ensure.propertyIsNotNull(value.getLocalId(), value, "localId");
		Ensure.propertyEquals(value.getNamespace(), value, "namespace",
				DBNetzConstants.NAMESPACE);
		Ensure.propertyIsNil(value.getVersionId(), value, "versionId");
		final String localId = value.getLocalId();
		return localId.trim();
	}

}
