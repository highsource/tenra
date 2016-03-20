package org.hisrc.tenra.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.builder.ModelBuilder;
import org.hisrc.tenra.model.MarkerPost;
import org.hisrc.tenra.model.RailwayLine;
import org.hisrc.tenra.model.RailwayLink;
import org.hisrc.tenra.model.RailwayLinkSequence;
import org.hisrc.tenra.model.RailwayNode;
import org.hisrc.tenra.model.RailwayStationNode;
import org.hisrc.tenra.parser.Parser;
import org.hisrc.tenra.serializer.Serializer;
import org.hisrc.tenra.serializer.json.GenericJsonSerializer;
import org.hisrc.tenra.settings.Settings;

public class Processor {

	public void process(Settings settings) throws IOException {
		final File inputFile = settings.getInputFile();
		final File outputDirectory = settings.getOutputDirectory();
		Validate.notNull(inputFile, "Input file must not be null.");
		Validate.isTrue(inputFile.isFile(), MessageFormat.format(
				"Input file [{0}] must be a file.", inputFile));
		Validate.notNull(outputDirectory, "Output directory must not be null.");
		Validate.isTrue(outputDirectory.isDirectory(), MessageFormat.format(
				"Output directory [{0}] must be a directory.", outputDirectory));
		final Parser parser = new Parser();
		final ModelBuilder builder = new ModelBuilder();
		try (final InputStream is = new FileInputStream(settings.getInputFile());) {
			parser.parse(is, builder);
		}
		builder.build();
		final Serializer<Object> serializer = new GenericJsonSerializer(settings);
		serializer.start();
		for (RailwayNode item : builder.getRailwayNodes())
		{
			serializer.serialize(item);
		}
		for (RailwayLink item : builder.getRailwayLinks())
		{
			serializer.serialize(item);
		}
		for (RailwayStationNode item : builder.getRailwayStationNodes())
		{
			serializer.serialize(item);
		}
		for (RailwayLine item : builder.getRailwayLines())
		{
			serializer.serialize(item);
		}
		for (RailwayLinkSequence item : builder.getRailwayLinkSequences())
		{
			serializer.serialize(item);
		}
		for (MarkerPost item : builder.getMarkerPosts())
		{
			serializer.serialize(item);
		}
		serializer.end();
	}
}
