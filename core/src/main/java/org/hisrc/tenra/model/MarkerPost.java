package org.hisrc.tenra.model;

import java.util.List;

public class MarkerPost {

	private String id;
	private RailwayLine railwayLine;
	private String railwayLineId;
	private String railwayLineGeographicalName;
	private String railwayLineCode;
	private Double location;
	private List<Double> coordinates;

	public MarkerPost(String id, String railwayLineId, Double location,
			List<Double> coordinates) {
		this.id = id;
		this.railwayLineId = railwayLineId;
		this.location = location;
		this.coordinates = coordinates;
	}

	public String getId() {
		return id;
	}

	public String getRailwayLineId() {
		return railwayLineId;
	}

	public RailwayLine getRailwayLine() {
		return railwayLine;
	}

	public void setRailwayLine(RailwayLine railwayLine) {
		this.railwayLine = railwayLine;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public Double getLocation() {
		return location;
	}

	public String getRailwayLineCode() {
		return railwayLineCode;
	}

	public void setRailwayLineCode(String railwayLineCode) {
		this.railwayLineCode = railwayLineCode;
	}

	public String getRailwayLineGeographicalName() {
		return railwayLineGeographicalName;
	}

	public void setRailwayLineGeographicalName(
			String railwayLineGeographicalName) {
		this.railwayLineGeographicalName = railwayLineGeographicalName;
	}
}
