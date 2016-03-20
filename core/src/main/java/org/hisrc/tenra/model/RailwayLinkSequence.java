package org.hisrc.tenra.model;

import java.util.List;

import org.apache.commons.lang3.Validate;

public class RailwayLinkSequence {

	private String id;
	private List<RailwayLink> railwayLinks;
	private List<String> railwayLinkIds;
	private RailwayLine railwayLine;
	private String railwayLineId;
	private String railwayLineGeographicalName;
	private String railwayLineCode;

	public RailwayLinkSequence(String id, List<String> railwayLinkIds) {
		this.id = id;
		this.railwayLinkIds = railwayLinkIds;
	}

	public String getId() {
		return id;
	}

	public List<String> getRailwayLinkIds() {
		return railwayLinkIds;
	}

	public List<RailwayLink> getRailwayLinks() {
		return railwayLinks;
	}

	public void setRailwayLinks(List<RailwayLink> railwayLinks) {
		this.railwayLinks = railwayLinks;
	}

	public RailwayLine getRailwayLine() {
		return railwayLine;
	}

	public void setRailwayLine(RailwayLine railwayLine) {
		Validate.notNull(railwayLine);
		this.railwayLine = railwayLine;
		this.railwayLineId = railwayLine.getId();
		this.railwayLineGeographicalName = railwayLine.getGeographicalName();
		this.railwayLineCode = railwayLine.getRailwayLineCode();
	}

	public String getRailwayLineId() {
		return railwayLineId;
	}

	public String getRailwayLineGeographicalName() {
		return railwayLineGeographicalName;
	}

	public String getRailwayLineCode() {
		return railwayLineCode;
	}

}
