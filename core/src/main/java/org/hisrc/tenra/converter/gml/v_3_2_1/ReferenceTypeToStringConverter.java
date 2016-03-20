package org.hisrc.tenra.converter.gml.v_3_2_1;

import net.opengis.gml.v_3_2_1.ReferenceType;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.util.Ensure;

public class ReferenceTypeToStringConverter implements
		Converter<ReferenceType, String> {

	public static final Converter<ReferenceType, String> INSTANCE = new ReferenceTypeToStringConverter();

	@Override
	public String convert(ReferenceType value) {
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		Ensure.propertyIsNull(value.getActuate(), value, "actuate");
		Ensure.propertyIsNull(value.getArcrole(), value, "arcrole");
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		Ensure.propertyIsNull(value.getRemoteSchema(), value, "remoteSchema");
		Ensure.propertyIsNull(value.getRole(), value, "role");
		Ensure.propertyIsNull(value.getShow(), value, "show");
		Ensure.propertyIsNull(value.getTitle(), value, "title");
		Ensure.propertyIsNull(value.getTYPE(), value, "type");
		final String href = value.getHref();
		Ensure.propertyIsNotNull(href, value, "href");
		if (href.isEmpty()) {
			return null;
		} else {
			Ensure.propertyStartsWith(href, value, "href",
					DBNetzConstants.ID_COLON_PREFIX);
			return href.substring(DBNetzConstants.ID_COLON_PREFIX.length())
					.trim();
		}
	}

}
