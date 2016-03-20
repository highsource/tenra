package org.hisrc.tenra.parser;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.hisrc.tenra.builder.ModelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parser {

	public static final QName WFS_FEATURE_COLLECTION_QNAME = new QName(
			"http://www.opengis.net/wfs/2.0", "FeatureCollection");
	public static final QName WFS_MEMBER_QNAME = new QName(
			"http://www.opengis.net/wfs/2.0", "member");

	private Logger logger = LoggerFactory.getLogger(Parser.class);

	private JAXBContext context;
	{
		try {
			context = JAXBContext
					.newInstance(

					"inspire.x.specification.gmlas.basetypes._3:"
							+ "inspire.x.specification.gmlas.commontransportelements._3:"
							+ "inspire.x.specification.gmlas.geographicalnames._3:"
							+ "inspire.x.specification.gmlas.network._3:"
							+ "inspire.x.specification.gmlas.railwaytransportnetwork._3:"
							+ "inspire.x.specification.gmlas.roadtransportnetwork._3:"
							+ "org.hisrc.w3c.xlink.v_1_0:"
							+ "net.opengis.gml.v_3_2_1:"
							+ "net.opengis.iso19139.gco.v_20070417:"
							+ "net.opengis.iso19139.gmd.v_20070417:"
							+ "net.opengis.iso19139.gmx.v_20070417:"
							+ "net.opengis.iso19139.gsr.v_20070417:"
							+ "net.opengis.iso19139.gss.v_20070417:"
							+ "net.opengis.iso19139.gts.v_20070417:"
							+ "net.opengis.iso19139.gco.v_20070417");
		} catch (JAXBException jaxbex) {
			throw new AssertionError(jaxbex);
		}
	}

	public void parse(InputStream is, ModelBuilder builder) throws IOException {
		XMLInputFactory inputFactory = XMLInputFactory.newFactory();
		try {
			final XMLStreamReader streamReader = inputFactory
					.createXMLStreamReader(is);
			while (streamReader.hasNext()) {
				final int next = streamReader.next();
				if (next == XMLStreamConstants.START_ELEMENT) {
					final QName name = streamReader.getName();
					if (name.equals(WFS_FEATURE_COLLECTION_QNAME)) {
						parseFeatureCollection(streamReader, builder);
					}
				}
			}
		} catch (XMLStreamException xsex) {
			throw new IOException("Error reading the XML stream.", xsex);
		} catch (JAXBException jaxbex) {
			throw new IOException("Error parsing the XML stream.", jaxbex);
		}
	}
	
	private void parseFeatureCollection(XMLStreamReader streamReader,
			ModelBuilder builder) throws XMLStreamException, JAXBException {
		while (streamReader.hasNext()) {
			final int next = streamReader.next();
			if (next == XMLStreamConstants.START_ELEMENT) {
				final QName name = streamReader.getName();
				if (name.equals(WFS_MEMBER_QNAME)) {
					final int nextTag = streamReader.nextTag();
					if (nextTag == XMLStreamConstants.START_ELEMENT) {
						final QName payloadName = streamReader.getName();
						if (payloadName.equals(WFS_FEATURE_COLLECTION_QNAME)) {
							parseFeatureCollection(streamReader, builder);
						} else {
							parsePayload(streamReader, builder);
						}
					}
				}
			}
		}
	}

	private void parsePayload(XMLStreamReader streamReader, ModelBuilder builder)
			throws JAXBException {
		final Unmarshaller unmarshaller = context.createUnmarshaller();
		final Object result = unmarshaller.unmarshal(streamReader);
		final Object value = JAXBIntrospector.getValue(result);
		builder.add(value);
	}
}
