package org.hisrc.tenra.converter.geojson;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;

import org.hisrc.tenra.converter.Converter;
import org.hisrc.tenra.model.RailwayLink;

public class RailwayLinkToJsonObjectConverter implements
		Converter<RailwayLink, JsonObject> {

	public static final Converter<RailwayLink, JsonObject> INSTANCE = new RailwayLinkToJsonObjectConverter();

	@Override
	public JsonObject convert(RailwayLink value) {

		final JsonObjectBuilder builder = JsonProvider.provider()
				.createObjectBuilder();

		builder.add("type", "Feature");
		builder.add("geometry",
				DoublesToLineStringGeometryJsonObjectConverter.INSTANCE
						.convert(value.getCoordinates()));

		final JsonObjectBuilder properties = JsonProvider.provider()
				.createObjectBuilder();

		properties.add("id", value.getId());
		final String startNodeId = value.getStartNodeId();
		if (startNodeId != null) {
			properties.add("sNodeId", startNodeId);
		} else {
			properties.addNull("sNodeId");
		}
		final String endNodeId = value.getEndNodeId();
		if (endNodeId != null) {
			properties.add("eNodeId", endNodeId);
		} else {
			properties.addNull("eNodeId");
		}

		properties.add("lineId", value.getRailwayLineId());
		properties.add("lineCode", value.getRailwayLineCode());
		properties.add("lineName",
				value.getRailwayLineGeographicalName());

		properties.add("linkSeqId", value.getRailwayLinkSequenceId());

		builder.add("properties", properties);

		return builder.build();
	}
}
