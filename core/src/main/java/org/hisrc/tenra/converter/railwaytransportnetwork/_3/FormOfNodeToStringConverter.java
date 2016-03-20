package org.hisrc.tenra.converter.railwaytransportnetwork._3;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.InspireContsants;
import org.hisrc.tenra.util.Ensure;

import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayNodeType.FormOfNode;

public class FormOfNodeToStringConverter implements Converter<FormOfNode, String> {

	public static final Converter<FormOfNode, String> INSTANCE = new FormOfNodeToStringConverter();

	public String convert(FormOfNode value) {
		Ensure.propertyEquals(value.getCodeSpace(), value, "codeSpace",
				InspireContsants.CODESPACE_URI);
		Ensure.propertyIsEmpty(value.getNilReason(), value, "nilReason");
		final String formOfNode = value.getValue();
		Ensure.propertyIsNotNull(formOfNode, value, "value");
		return formOfNode.trim();
	}
}
