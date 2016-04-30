package org.hisrc.tenra.model;

import java.util.List;

public class RailwayLink implements Item {

	private String id;
	private String startNodeId;
	private RailwayNode startNode;
	private String endNodeId;
	private RailwayNode endNode;
	private List<Double> coordinates;
	private RailwayLine railwayLine;
	private String railwayLineId;
	private String railwayLineCode;
	private String railwayLineGeographicalName;
	private String railwayLinkSequenceId;
	private RailwayLinkSequence railwayLinkSequence;

	public RailwayLink(String id, String startNodeId, String endNodeId,
			List<Double> coordinates) {
		this.id = id;
		this.startNodeId = startNodeId;
		this.endNodeId = endNodeId;
		this.coordinates = coordinates;
	}

	public String getId() {
		return this.id;
	}

	public String getStartNodeId() {
		return startNodeId;
	}
	
	public void setStartNodeId(String startNodeId) {
		this.startNodeId = startNodeId;
	}

	public String getEndNodeId() {
		return this.endNodeId;
	}
	
	public void setEndNodeId(String endNodeId) {
		this.endNodeId = endNodeId;
	}

	public RailwayNode getStartNode() {
		return startNode;
	}

	public void setStartNode(RailwayNode startNode) {
		this.startNode = startNode;
	}

	public RailwayNode getEndNode() {
		return endNode;
	}

	public void setEndNode(RailwayNode endNode) {
		this.endNode = endNode;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public RailwayLine getRailwayLine() {
		return railwayLine;
	}

	public void setRailwayLine(RailwayLine railwayLine) {
		this.railwayLine = railwayLine;
	}

	public String getRailwayLineId() {
		return railwayLineId;
	}

	public void setRailwayLineId(String railwayLineId) {
		this.railwayLineId = railwayLineId;
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

	public RailwayLinkSequence getRailwayLinkSequence() {
		return railwayLinkSequence;
	}

	public void setRailwayLinkSequence(RailwayLinkSequence railwayLinkSequence) {
		this.railwayLinkSequence = railwayLinkSequence;
	}

	public String getRailwayLinkSequenceId() {
		return railwayLinkSequenceId;
	}

	public void setRailwayLinkSequenceId(String railwayLinkSequenceId) {
		this.railwayLinkSequenceId = railwayLinkSequenceId;
	}
}