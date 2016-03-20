package org.hisrc.tenra.serializer;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.lang3.Validate;
import org.hisrc.tenra.model.MarkerPost;
import org.hisrc.tenra.model.RailwayLine;
import org.hisrc.tenra.model.RailwayLink;
import org.hisrc.tenra.model.RailwayLinkSequence;
import org.hisrc.tenra.model.RailwayNode;
import org.hisrc.tenra.model.RailwayStationNode;

public class GenericSerializer implements Serializer<Object> {

	private final Serializer<RailwayNode> railwayNodeSerializer;
	private final Serializer<RailwayLink> railwayLinkSerializer;
	private final Serializer<RailwayStationNode> railwayStationNodeSerializer;
	private final Serializer<RailwayLine> railwayLineSerializer;
	private final Serializer<RailwayLinkSequence> railwayLinkSequenceSerializer;
	private final Serializer<MarkerPost> markerPostSerializer;

	public GenericSerializer(Serializer<RailwayNode> railwayNodeSerializer,
			Serializer<RailwayLink> railwayLinkSerializer,
			Serializer<RailwayStationNode> railwayStationNodeSerializer,
			Serializer<RailwayLine> railwayLineSerializer,
			Serializer<RailwayLinkSequence> railwayLinkSequenceSerializer,
			Serializer<MarkerPost> markerPostSerializer) {
		Validate.notNull(railwayNodeSerializer);
		Validate.notNull(railwayLinkSerializer);
		Validate.notNull(railwayStationNodeSerializer);
		Validate.notNull(railwayLineSerializer);
		Validate.notNull(railwayLinkSequenceSerializer);
		Validate.notNull(markerPostSerializer);
		this.railwayNodeSerializer = railwayNodeSerializer;
		this.railwayLinkSerializer = railwayLinkSerializer;
		this.railwayStationNodeSerializer = railwayStationNodeSerializer;
		this.railwayLineSerializer = railwayLineSerializer;
		this.railwayLinkSequenceSerializer = railwayLinkSequenceSerializer;
		this.markerPostSerializer = markerPostSerializer;
	}

	@Override
	public void start() throws IOException {
		this.railwayNodeSerializer.start();
		this.railwayLinkSerializer.start();
		this.railwayStationNodeSerializer.start();
		this.railwayLineSerializer.start();
		this.railwayLinkSequenceSerializer.start();
		this.markerPostSerializer.start();
	}

	@Override
	public void end() throws IOException {
		this.railwayNodeSerializer.end();
		this.railwayLinkSerializer.end();
		this.railwayStationNodeSerializer.end();
		this.railwayLineSerializer.end();
		this.railwayLinkSequenceSerializer.end();
		this.markerPostSerializer.end();
	}

	@Override
	public void serialize(Object value) throws IOException {
		Validate.notNull(value);
		if (value instanceof RailwayNode) {
			this.railwayNodeSerializer.serialize((RailwayNode) value);
		} else if (value instanceof RailwayLink) {
			this.railwayLinkSerializer.serialize((RailwayLink) value);
		} else if (value instanceof RailwayStationNode) {
			this.railwayStationNodeSerializer
					.serialize((RailwayStationNode) value);
		} else if (value instanceof RailwayLine) {
			this.railwayLineSerializer.serialize((RailwayLine) value);
		} else if (value instanceof RailwayLinkSequence) {
			this.railwayLinkSequenceSerializer
					.serialize((RailwayLinkSequence) value);
		} else if (value instanceof MarkerPost) {
			this.markerPostSerializer.serialize((MarkerPost) value);
		} else {
			throw new IllegalArgumentException(MessageFormat.format(
					"Unexpected class [{0}].", value.getClass()));
		}
	}

}
