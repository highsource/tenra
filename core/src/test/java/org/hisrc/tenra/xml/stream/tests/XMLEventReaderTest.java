package org.hisrc.tenra.xml.stream.tests;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import org.hisrc.tenra.builder.ModelBuilder;
import org.hisrc.tenra.parser.Parser;
import org.junit.Test;

public class XMLEventReaderTest {

	@Test
	public void parse() throws XMLStreamException, IOException, JAXBException {
		try (InputStream is = getClass().getResourceAsStream(
				"/DB-Netz_INSPIRE_20131128.xml")) {
			ModelBuilder builder = new ModelBuilder();
			new Parser().parse(is, builder);
			builder.build();
		}
	}
}
