package org.hisrc.tenra.model;

import org.apache.commons.lang3.Validate;

public class RailwayLinkSequenceLinearReference {

	private final String railwayLinkSequenceId;
	private final double fromPosition;
	private final double toPosition;

	public RailwayLinkSequenceLinearReference(String railwayLinkSequenceId,
			Double fromPosition, Double toPosition) {
		Validate.notNull(railwayLinkSequenceId);
		Validate.notNull(fromPosition);
		Validate.notNull(toPosition);
		this.railwayLinkSequenceId = railwayLinkSequenceId;
		this.fromPosition = fromPosition;
		this.toPosition = toPosition;
	}

	public String getRailwayLinkSequenceId() {
		return railwayLinkSequenceId;
	}

	public double getFromPosition() {
		return fromPosition;
	}

	public double getToPosition() {
		return toPosition;
	}
}
