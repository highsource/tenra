package org.hisrc.tenra.converter.gml.v_3_2_1;

import javax.xml.namespace.QName;

import org.apache.commons.lang3.Validate;

public class GMLConstants {

	public static final String DEFAULT_PREFIX = "gml";
	public static final String NAMESPACE_URI = "http://www.opengis.net/gml/3.2";
	public static final String LINE_STRING_LOCAL_NAME = "LineString";
	public static final QName LINE_STRING_QNAME = gml(LINE_STRING_LOCAL_NAME);

	private GMLConstants() {
	}

	public static QName gml(String localName) {
		Validate.notNull(localName);
		return new QName(NAMESPACE_URI, localName, DEFAULT_PREFIX);
	}
}
