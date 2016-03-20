package org.hisrc.tenra.converter.network._3;

import inspire.x.specification.gmlas.network._3.LinkSetType.Link;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.DBNetzConstants;
import org.hisrc.tenra.util.Ensure;

public class LinkSetType_LinkToIdConverter implements Converter<Link, String> {

	public static final Converter<Link, String> INSTANCE = new LinkSetType_LinkToIdConverter();

	@Override
	public String convert(Link value) {
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		Ensure.propertyIsNull(value.getActuate(), value, "actuate");
		Ensure.propertyIsNull(value.getArcrole(), value, "arcrole");
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		Ensure.propertyIsNull(value.getRemoteSchema(), value, "remoteSchema");
		Ensure.propertyIsNull(value.getRole(), value, "role");
		Ensure.propertyIsNull(value.getShow(), value, "show");
		Ensure.propertyIsNull(value.getTitle(), value, "title");
		Ensure.propertyIsNull(value.getTYPE(), value, "type");
		Ensure.propertyIsNotNull(value.getHref(), value, "href");
		Ensure.propertyStartsWith(value.getHref(), value, "href",
				DBNetzConstants.ID_COLON_PREFIX);
		final String id = value.getHref().substring(
				DBNetzConstants.ID_COLON_PREFIX.length());
		return id;
	}
}
