package org.hisrc.tenra.model;

import java.util.List;

public class RailwayNode implements Item {

	private String id;
	private String geographicalName;
	private String formOfNode;
	private List<RailwayLink> spokeStarts;
	private List<String> spokeStartIds;
	private List<RailwayLink> spokeEnds;
	private List<String> spokeEndIds;
	private List<Double> coordinates;

	public RailwayNode(String id, String geographicalName, String formOfNode,
			List<String> spokeStartIds, List<String> spokeEndIds,
			List<Double> coordinates) {
		this.id = id;
		this.geographicalName = geographicalName;
		this.formOfNode = formOfNode;
		this.spokeStartIds = spokeStartIds;
		this.spokeEndIds = spokeEndIds;
		this.coordinates = coordinates;
	}

	public String getId() {
		return id;
	}

	public List<String> getSpokeStartIds() {
		return spokeStartIds;
	}

	public List<String> getSpokeEndIds() {
		return spokeEndIds;
	}

	public List<RailwayLink> getSpokeStarts() {
		return spokeStarts;
	}

	public void setSpokeStarts(List<RailwayLink> spokeStarts) {
		this.spokeStarts = spokeStarts;
	}

	public List<RailwayLink> getSpokeEnds() {
		return spokeEnds;
	}

	public void setSpokeEnds(List<RailwayLink> spokeEnds) {
		this.spokeEnds = spokeEnds;
	}

	public String getFormOfNode() {
		return formOfNode;
	}

	public String getGeographicalName() {
		return geographicalName;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}
}
