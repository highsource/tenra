package org.hisrc.tenra.model;

public class RailwayStationCode implements Item {

	private String id;
	private RailwayStationNode railwayStationNode;
	private String railwayStationNodeId;
	private String stationCode;

	public RailwayStationCode(String id, String railwayStationNodeId,
			String stationCode) {
		this.id = id;
		this.railwayStationNodeId = railwayStationNodeId;
		this.stationCode = stationCode;
	}

	public String getId() {
		return id;
	}

	public String getRailwayStationNodeId() {
		return railwayStationNodeId;
	}

	public String getStationCode() {
		return stationCode;
	}

	public RailwayStationNode getRailwayStationNode() {
		return railwayStationNode;
	}

	public void setRailwayStationNode(RailwayStationNode railwayStationNode) {
		this.railwayStationNode = railwayStationNode;
	}

}
