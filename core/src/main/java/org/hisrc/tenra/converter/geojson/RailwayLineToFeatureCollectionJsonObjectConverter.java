//package org.hisrc.tenra.converter.geojson;
//
//import javax.json.JsonArrayBuilder;
//import javax.json.JsonObject;
//import javax.json.JsonObjectBuilder;
//import javax.json.spi.JsonProvider;
//
//import org.hisrc.tenra.converter.Converter;
//import org.hisrc.tenra.model.RailwayLine;
//import org.hisrc.tenra.model.RailwayLink;
//
//public class RailwayLineToFeatureCollectionJsonObjectConverter implements
//		Converter<RailwayLine, JsonObject> {
//
//	public static final Converter<RailwayLine, JsonObject> INSTANCE = new RailwayLineToFeatureCollectionJsonObjectConverter();
//
//	@Override
//	public JsonObject convert(RailwayLine value) {
//
//		final JsonObjectBuilder builder = JsonProvider.provider()
//				.createObjectBuilder();
//
//		builder.add("type", "FeatureCollection");
//
//		final JsonObjectBuilder properties = JsonProvider.provider()
//				.createObjectBuilder();
//
//		properties.add("id", value.getId());
//		properties.add("geographicalName", value.getGeographicalName());
//		properties.add("railwayLineCode", value.getRailwayLineCode());
//		builder.add("properties", properties);
//
//		final JsonArrayBuilder featuresBuilder = JsonProvider.provider()
//				.createArrayBuilder();
//
//		for (RailwayLink railwayLink : value.getRailwayLinks()) {
//			featuresBuilder.add(RailwayLinkToJsonObjectConverter.INSTANCE
//					.convert(railwayLink));
//		}
//
//		builder.add("features", featuresBuilder.build());
//
//		return builder.build();
//	}
//}
