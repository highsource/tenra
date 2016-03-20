package org.hisrc.tenra.serializer.json;

import java.io.File;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.converter.geojson.MarkerPostToJsonObjectConverter;
import org.hisrc.tenra.converter.geojson.RailwayLineToJsonObjectConverter;
import org.hisrc.tenra.converter.geojson.RailwayLinkSequenceToJsonObjectConverter;
import org.hisrc.tenra.converter.geojson.RailwayLinkToJsonObjectConverter;
import org.hisrc.tenra.converter.geojson.RailwayNodeToJsonObjectConverter;
import org.hisrc.tenra.converter.geojson.RailwayStationNodeToJsonObjectConverter;
import org.hisrc.tenra.model.MarkerPost;
import org.hisrc.tenra.model.RailwayLine;
import org.hisrc.tenra.model.RailwayLink;
import org.hisrc.tenra.model.RailwayLinkSequence;
import org.hisrc.tenra.model.RailwayNode;
import org.hisrc.tenra.model.RailwayStationNode;
import org.hisrc.tenra.serializer.GenericSerializer;
import org.hisrc.tenra.settings.Settings;

public class GenericJsonSerializer extends GenericSerializer {

	public GenericJsonSerializer(Settings settings) {
		super(
				new FeatureCollectionSerializer<RailwayNode>(
						RailwayNodeToJsonObjectConverter.INSTANCE,
						new File(
								Validate.notNull(settings.getOutputDirectory()),
								"railwayNodes.geojson")),
				new FeatureCollectionSerializer<RailwayLink>(
						RailwayLinkToJsonObjectConverter.INSTANCE,
						new File(
								Validate.notNull(settings.getOutputDirectory()),
								"railwayLinks.geojson")),
				new FeatureCollectionSerializer<RailwayStationNode>(
						RailwayStationNodeToJsonObjectConverter.INSTANCE,
						new File(
								Validate.notNull(settings.getOutputDirectory()),
								"railwayStationNodes.geojson")),
				// new MultipleSerializer<RailwayLine>(
				new FeatureCollectionSerializer<RailwayLine>(
						RailwayLineToJsonObjectConverter.INSTANCE,
						new File(
								Validate.notNull(settings.getOutputDirectory()),
								"railwayLines.geojson")),
				new FeatureCollectionSerializer<RailwayLinkSequence>(
						RailwayLinkSequenceToJsonObjectConverter.INSTANCE,
						new File(
								Validate.notNull(settings.getOutputDirectory()),
								"railwayLinkSequences.geojson")),
				// new FeatureCollectionSerializer<RailwayLine>(
				// RailwayLineToFeatureCollectionJsonObjectConverter.INSTANCE,
				// new File(Validate.notNull(settings
				// .getOutputDirectory()),
				// "railwayLineFeatureCollections.geojson"))),
				new FeatureCollectionSerializer<MarkerPost>(
						MarkerPostToJsonObjectConverter.INSTANCE,
						new File(
								Validate.notNull(settings.getOutputDirectory()),
								"markerPosts.geojson")));
	}
}
