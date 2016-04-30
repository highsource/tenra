package org.hisrc.tenra.model;

import java.util.List;

public class RailwayStationNode extends RailwayNode {
	
	public RailwayStationNode(String id, String geographicalName, String formOfNode, List<String> spokeStartIds,
			List<String> spokeEndIds, List<Double> coordinates) {
		super(id, geographicalName, formOfNode, spokeStartIds, spokeEndIds, coordinates);
	}

	private RailwayStationCode railwayStationCode;

	public RailwayStationCode getRailwayStationCode() {
		return railwayStationCode;
	}

	public void setRailwayStationCode(RailwayStationCode railwayStationCode) {
		this.railwayStationCode = railwayStationCode;
	}
}
