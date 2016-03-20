package org.hisrc.tenra.model;

import java.util.List;

public class RailwayLine implements Item {

	private String id;
	private String geographicalName;
	private String railwayLineCode;
	private List<RailwayLink> railwayLinks;
	private List<String> railwayLinkIds;

	public RailwayLine(String id, String geographicalName, String code,
			List<String> linkIds) {
		this.id = id;
		this.geographicalName = geographicalName;
		this.railwayLinkIds = linkIds;
		this.railwayLineCode = code;
	}

	public String getId() {
		return id;
	}

	public String getGeographicalName() {
		return geographicalName;
	}

	public List<RailwayLink> getRailwayLinks() {
		return railwayLinks;
	}

	public void setRailwayLinks(List<RailwayLink> links) {
		this.railwayLinks = links;
	}

	public List<String> getRailwayLinkIds() {
		return railwayLinkIds;
	}

	public String getRailwayLineCode() {
		return railwayLineCode;
	}
}
