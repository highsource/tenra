package org.hisrc.tenra.builder;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

import org.apache.commons.lang3.Validate;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.hisrc.tenra.converter.commontransportelements._3.MarkerPostTypeConverter;
import org.hisrc.tenra.converter.railwaytransportnetwork._3.RailwayLineTypeConverter;
import org.hisrc.tenra.converter.railwaytransportnetwork._3.RailwayLinkSequenceTypeConverter;
import org.hisrc.tenra.converter.railwaytransportnetwork._3.RailwayLinkTypeConverter;
import org.hisrc.tenra.converter.railwaytransportnetwork._3.RailwayNodeTypeConverter;
import org.hisrc.tenra.converter.railwaytransportnetwork._3.RailwayStationCodeTypeConverter;
import org.hisrc.tenra.converter.railwaytransportnetwork._3.RailwayStationNodeTypeConverter;
import org.hisrc.tenra.geometry.euclidean.DistanceCalculator;
import org.hisrc.tenra.model.MarkerPost;
import org.hisrc.tenra.model.RailwayLine;
import org.hisrc.tenra.model.RailwayLink;
import org.hisrc.tenra.model.RailwayLinkSequence;
import org.hisrc.tenra.model.RailwayNode;
import org.hisrc.tenra.model.RailwayStationCode;
import org.hisrc.tenra.model.RailwayStationNode;
import org.hisrc.tenra.util.Ensure;

import inspire.x.specification.gmlas.commontransportelements._3.ConditionOfFacilityType;
import inspire.x.specification.gmlas.commontransportelements._3.MaintenanceAuthorityType;
import inspire.x.specification.gmlas.commontransportelements._3.MarkerPostType;
import inspire.x.specification.gmlas.commontransportelements._3.OwnerAuthorityType;
import inspire.x.specification.gmlas.commontransportelements._3.TrafficFlowDirectionType;
import inspire.x.specification.gmlas.commontransportelements._3.VerticalPositionType;
import inspire.x.specification.gmlas.network._3.NetworkType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.DesignSpeedType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.NominalTrackGaugeType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.NumberOfTracksType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayElectrificationType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLineType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLinkSequenceType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayLinkType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayNodeType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayStationCodeType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayStationNodeType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayTypeType;
import inspire.x.specification.gmlas.railwaytransportnetwork._3.RailwayUseType;

public class ModelBuilder {

	public void add(Object value) {
		if (value instanceof RailwayLinkType) {
			addRailwayLink((RailwayLinkType) value);
		} else if (value instanceof RailwayLinkSequenceType) {
			addRailwayLinkSequence((RailwayLinkSequenceType) value);
		} else if (value instanceof RailwayStationCodeType) {
			addRailwayStationCode((RailwayStationCodeType) value);
		} else if (value instanceof RailwayElectrificationType) {
			addRailwayElectrification((RailwayElectrificationType) value);
		} else if (value instanceof RailwayLineType) {
			addRailwayLine((RailwayLineType) value);
		} else if (value instanceof DesignSpeedType) {
			addDesignSpeed((DesignSpeedType) value);
		} else if (value instanceof OwnerAuthorityType) {
			addOwnerAuthority((OwnerAuthorityType) value);
		} else if (value instanceof NominalTrackGaugeType) {
			addNominalTrackGauge((NominalTrackGaugeType) value);
		} else if (value instanceof TrafficFlowDirectionType) {
			addTrafficFlowDirection((TrafficFlowDirectionType) value);
		} else if (value instanceof RailwayStationNodeType) {
			addRailwayStationNode((RailwayStationNodeType) value);
		} else if (value instanceof NetworkType) {
			addNetwork((NetworkType) value);
		} else if (value instanceof RailwayTypeType) {
			addRailwayType((RailwayTypeType) value);
		} else if (value instanceof ConditionOfFacilityType) {
			addConditionOfFacility((ConditionOfFacilityType) value);
		} else if (value instanceof NumberOfTracksType) {
			addNumberOfTracks((NumberOfTracksType) value);
		} else if (value instanceof RailwayUseType) {
			addRailwayUse((RailwayUseType) value);
		} else if (value instanceof MarkerPostType) {
			addMarkerPost((MarkerPostType) value);
		} else if (value instanceof RailwayNodeType) {
			addRailwayNode((RailwayNodeType) value);
		} else if (value instanceof MaintenanceAuthorityType) {
			addMaintenanceAuthority((MaintenanceAuthorityType) value);
		} else if (value instanceof VerticalPositionType) {
			addVerticalPosition((VerticalPositionType) value);
		} else {
			throw new IllegalArgumentException(
					MessageFormat.format("Unsupported class [{0}], value [{1}].", value.getClass(), value));
		}
	}

	private void addNetwork(NetworkType value) {
	}

	private void addOwnerAuthority(OwnerAuthorityType value) {
	}

	private void addMaintenanceAuthority(MaintenanceAuthorityType value) {
	}

	private final Map<String, RailwayNode> railwayNodes = new HashMap<String, RailwayNode>();
	private final Map<String, RailwayNode> railwayAndStationNodes = new HashMap<String, RailwayNode>();
	private final Map<String, String> railwayLinkStartingRailwayNodeIds = new HashMap<String, String>();
	private final Map<String, String> railwayLinkEndingRailwayNodeIds = new HashMap<String, String>();

	private void addRailwayNode(RailwayNodeType value) {
		final RailwayNode railwayNode = RailwayNodeTypeConverter.INSTANCE.convert(value);
		railwayNodes.put(railwayNode.getId(), railwayNode);
		addRailwayOrStationNode(railwayNode);
	}

	private void addRailwayOrStationNode(final RailwayNode railwayNode) {
		final String railwayNodeId = railwayNode.getId();
		railwayAndStationNodes.put(railwayNodeId, railwayNode);
		for (String spokeStartId : railwayNode.getSpokeStartIds()) {
			Validate.notNull(spokeStartId);
			String existingRailwayLinkStartingRailwayNodeId = railwayLinkStartingRailwayNodeIds.get(spokeStartId);
			if (existingRailwayLinkStartingRailwayNodeId != null
					&& !Objects.equals(existingRailwayLinkStartingRailwayNodeId, railwayNodeId)) {
				System.err.println(MessageFormat.format(
						"Another starting railway node {0} found for the railway link {1}, the other railway node is {2}.",
						railwayNodeId, spokeStartId, existingRailwayLinkStartingRailwayNodeId));
			}
			railwayLinkStartingRailwayNodeIds.put(spokeStartId, railwayNodeId);
		}
		for (String spokeEndId : railwayNode.getSpokeEndIds()) {
			Validate.notNull(spokeEndId);
			String existingRailwayLinkEndingRailwayNodeId = railwayLinkEndingRailwayNodeIds.get(spokeEndId);
			if (existingRailwayLinkEndingRailwayNodeId != null
					&& !Objects.equals(existingRailwayLinkEndingRailwayNodeId, railwayNodeId)) {
				System.err.println(MessageFormat.format(
						"Another ending railway node {0} found for the railway link {1}, the other railway node is {2}.",
						railwayNodeId, spokeEndId, existingRailwayLinkEndingRailwayNodeId));
			}
			railwayLinkEndingRailwayNodeIds.put(spokeEndId, railwayNodeId);
		}
	}

	private final Map<String, RailwayLink> railwayLinks = new HashMap<String, RailwayLink>();

	private void addRailwayLink(RailwayLinkType value) {
		final RailwayLink railwayLink = RailwayLinkTypeConverter.INSTANCE.convert(value);
		railwayLinks.put(railwayLink.getId(), railwayLink);
	}

	private Map<String, RailwayStationNode> railwayStationNodes = new HashMap<>();

	private void addRailwayStationNode(RailwayStationNodeType value) {
		final RailwayStationNode railwayStationNode = RailwayStationNodeTypeConverter.INSTANCE.convert(value);
		final String railwayStationNodeId = railwayStationNode.getId();
		railwayStationNodes.put(railwayStationNodeId, railwayStationNode);
		addRailwayOrStationNode(railwayStationNode);
	}

	private Map<String, RailwayStationCode> railwayStationCodes = new HashMap<>();

	private void addRailwayStationCode(RailwayStationCodeType value) {
		final RailwayStationCode railwayStationCode = RailwayStationCodeTypeConverter.INSTANCE.convert(value);
		railwayStationCodes.put(railwayStationCode.getId(), railwayStationCode);
	}

	private Map<String, RailwayLine> railwayLines = new HashMap<>();

	private void addRailwayLine(RailwayLineType value) {
		final RailwayLine railwayLine = RailwayLineTypeConverter.INSTANCE.convert(value);
		railwayLines.put(railwayLine.getId(), railwayLine);
	}

	private Map<String, MarkerPost> markerPosts = new HashMap<>();

	private void addMarkerPost(MarkerPostType value) {
		final MarkerPost markerPost = MarkerPostTypeConverter.INSTANCE.convert(value);
		// TODO
		if (markerPost.getRailwayLineId() != null) {
			markerPosts.put(markerPost.getId(), markerPost);
		}
	}

	private Map<String, RailwayLinkSequence> railwayLinkSequences = new HashMap<>();

	private void addRailwayLinkSequence(RailwayLinkSequenceType value) {
		final RailwayLinkSequence railwayLinkSequence = RailwayLinkSequenceTypeConverter.INSTANCE.convert(value);
		railwayLinkSequences.put(railwayLinkSequence.getId(), railwayLinkSequence);

	}

	private void addVerticalPosition(VerticalPositionType value) {
		// TODO Auto-generated method stub

	}

	private void addRailwayUse(RailwayUseType value) {
		// TODO Auto-generated method stub

	}

	private void addNumberOfTracks(NumberOfTracksType value) {
		// TODO Auto-generated method stub

	}

	private void addConditionOfFacility(ConditionOfFacilityType value) {
		// TODO Auto-generated method stub

	}

	private void addRailwayType(RailwayTypeType value) {
		// TODO Auto-generated method stub

	}

	private void addTrafficFlowDirection(TrafficFlowDirectionType value) {
		// TODO Auto-generated method stub

	}

	private void addNominalTrackGauge(NominalTrackGaugeType value) {
		// TODO Auto-generated method stub

	}

	private void addDesignSpeed(DesignSpeedType value) {
		// TODO Auto-generated method stub

	}

	private void addRailwayElectrification(RailwayElectrificationType value) {
		// TODO Auto-generated method stub

	}

	public void build() {
		buildRailwayNodes();
		buildRailwayStationNodes();
		buildRailwayStationCodes();
		buildRailwayLines();
		buildRailwayLinkSequences();
		buildRailwayLinks();
		buildMarkerPosts();
	}

	private void buildRailwayStationCodes() {
		for (RailwayStationCode railwayStationCode : this.railwayStationCodes.values()) {
			final String railwayStationNodeId = railwayStationCode.getRailwayStationNodeId();
			final RailwayStationNode railwayStationNode = Ensure.mapContainsKey(this.railwayStationNodes,
					railwayStationNodeId, "railwayStationNodes");
			if (railwayStationNode.getRailwayStationCode() != null) {
				Ensure.propertyIsNull(railwayStationNode.getRailwayStationCode(), railwayStationNode,
						"railwayStationCode");
			}
			railwayStationCode.setRailwayStationNode(railwayStationNode);
			railwayStationNode.setRailwayStationCode(railwayStationCode);
		}
	}

	private void buildRailwayNodes() {
		for (RailwayNode railwayNode : this.railwayAndStationNodes.values()) {
			final List<RailwayLink> spokeStarts = new ArrayList<>(railwayNode.getSpokeStartIds().size());
			final List<RailwayLink> spokeEnds = new ArrayList<>(railwayNode.getSpokeEndIds().size());
			for (String spokeStartId : railwayNode.getSpokeStartIds()) {
				Validate.notNull(spokeStartId);
				final RailwayLink spokeStart = Ensure.mapContainsKey(this.railwayLinks, spokeStartId, "railwayNodes");
				spokeStarts.add(spokeStart);
			}
			for (String spokeEndId : railwayNode.getSpokeEndIds()) {
				Validate.notNull(spokeEndId);
				final RailwayLink spokeEnd = Ensure.mapContainsKey(this.railwayLinks, spokeEndId, "railwayLinks");
				spokeEnds.add(spokeEnd);
			}
			railwayNode.setSpokeStarts(spokeStarts);
			railwayNode.setSpokeEnds(spokeEnds);
		}
	}

	private void buildRailwayStationNodes() {
		for (RailwayStationNode railwayStationNode : this.railwayStationNodes.values()) {
			final List<RailwayLink> spokeStarts = new ArrayList<>(railwayStationNode.getSpokeStartIds().size());
			final List<RailwayLink> spokeEnds = new ArrayList<>(railwayStationNode.getSpokeEndIds().size());
			for (String spokeStartId : railwayStationNode.getSpokeStartIds()) {
				Validate.notNull(spokeStartId);
				final RailwayLink spokeStart = Ensure.mapContainsKey(this.railwayLinks, spokeStartId, "railwayNodes");
				spokeStarts.add(spokeStart);

			}
			for (String spokeEndId : railwayStationNode.getSpokeEndIds()) {
				Validate.notNull(spokeEndId);
				final RailwayLink spokeEnd = Ensure.mapContainsKey(this.railwayLinks, spokeEndId, "railwayLinks");
				spokeEnds.add(spokeEnd);
			}
			railwayStationNode.setSpokeStarts(spokeStarts);
			railwayStationNode.setSpokeEnds(spokeEnds);
		}
	}

	private void buildRailwayLinks() {
		for (RailwayLink railwayLink : this.railwayLinks.values()) {
			final String id = railwayLink.getId();
			final String originalStartNodeId = railwayLink.getStartNodeId();
			final String railwayLinkStartingRailwayNodeId = railwayLinkStartingRailwayNodeIds.get(id);
			final String startNodeId;
			if (railwayLinkStartingRailwayNodeId != null) {
				if (originalStartNodeId != null
						&& !Objects.equals(originalStartNodeId, railwayLinkStartingRailwayNodeId)) {
					System.err.println(MessageFormat.format(
							"Railway link {0} has starting node id {1}, but there is another node {2} starting this link.",
							id, originalStartNodeId, railwayLinkStartingRailwayNodeId));
				}
				startNodeId = railwayLinkStartingRailwayNodeId;
			} else if (originalStartNodeId != null) {
				startNodeId = originalStartNodeId;
			} else {
				System.err.println(MessageFormat.format(
						"Railway link {0} has neither starting railway node nor staring railway station node.", id));
				startNodeId = null;
			}

			railwayLink.setStartNodeId(startNodeId);
			Ensure.propertyIsNotNull(startNodeId, railwayLink, "startNodeId");

			final RailwayNode startNode = Ensure.mapContainsKey(this.railwayAndStationNodes, startNodeId,
					"railwayNodes");
			railwayLink.setStartNode(startNode);

			final String originalEndNodeId = railwayLink.getEndNodeId();
			final String railwayLinkEndingRailwayNodeId = railwayLinkEndingRailwayNodeIds.get(id);
			final String endNodeId;
			if (railwayLinkEndingRailwayNodeId != null) {
				if (originalEndNodeId != null && !Objects.equals(originalEndNodeId, originalStartNodeId)
						&& !Objects.equals(originalEndNodeId, railwayLinkEndingRailwayNodeId)) {
					System.err.println(MessageFormat.format(
							"Railway link {0} has ending node id {1}, but there is another node {2} ending this link.",
							id, originalEndNodeId, railwayLinkEndingRailwayNodeId));
				}
				endNodeId = railwayLinkEndingRailwayNodeId;
			} else if (originalEndNodeId != null) {
				endNodeId = originalEndNodeId;
			} else {
				System.err.println(MessageFormat.format(
						"Railway link {0} has neither ending railway node nor staring railway station node.", id));
				endNodeId = null;
			}
			railwayLink.setEndNodeId(endNodeId);
			Ensure.propertyIsNotNull(endNodeId, railwayLink, "endNodeId");

			final RailwayNode endNode = Ensure.mapContainsKey(this.railwayAndStationNodes, endNodeId, "railwayNodes");
			railwayLink.setEndNode(endNode);
		}
	}

	private void buildRailwayLines() {
		for (RailwayLine railwayLine : this.railwayLines.values()) {
			final List<RailwayLink> railwayLinks = new ArrayList<>(railwayLine.getRailwayLinkIds().size());
			for (String linkId : railwayLine.getRailwayLinkIds()) {
				final RailwayLink railwayLink = Ensure.mapContainsKey(this.railwayLinks, linkId, "railwayLinks");
				railwayLinks.add(railwayLink);
				Ensure.propertyIsNull(railwayLink.getRailwayLine(), railwayLink, "railwayLine");
				railwayLink.setRailwayLine(railwayLine);
				railwayLink.setRailwayLineId(railwayLine.getId());
				railwayLink.setRailwayLineCode(railwayLine.getRailwayLineCode());
				railwayLink.setRailwayLineGeographicalName(railwayLine.getGeographicalName());
			}
			railwayLine.setRailwayLinks(railwayLinks);
		}
	}

	private void buildMarkerPosts() {
		for (MarkerPost markerPost : this.markerPosts.values()) {
			final String railwayLineId = markerPost.getRailwayLineId();
			final RailwayLine railwayLine = Ensure.mapContainsKey(this.railwayLines, railwayLineId, "railwayLines");
			markerPost.setRailwayLine(railwayLine);
			markerPost.setRailwayLineCode(railwayLine.getRailwayLineCode());
			markerPost.setRailwayLineGeographicalName(railwayLine.getGeographicalName());

			final double q0 = markerPost.getCoordinates().get(0);
			final double q1 = markerPost.getCoordinates().get(1);

			final NavigableMap<Double, List<Double>> distancesToLinks = new TreeMap<>();
			for (RailwayLink railwayLink : railwayLine.getRailwayLinks()) {
				final List<Double> railwayLinkCoordinates = railwayLink.getCoordinates();
				for (int index = 0; index < railwayLinkCoordinates.size() - 2; index += 2) {
					final List<Double> subList = railwayLinkCoordinates.subList(index, index + 4);
					final double a0 = railwayLinkCoordinates.get(index);
					final double a1 = railwayLinkCoordinates.get(index + 1);
					final double b0 = railwayLinkCoordinates.get(index + 2);
					final double b1 = railwayLinkCoordinates.get(index + 3);

					final double distance = DistanceCalculator.calculateDistance(new double[] { a0, a1 },
							new double[] { b0, b1 }, new double[] { q0, q1 });
					distancesToLinks.put(distance, subList);
				}
			}
			final Entry<Double, List<Double>> firstEntry = distancesToLinks.firstEntry();
			{
				// System.out.println("MarkerPost coordinates:"
				// + markerPost.getCoordinates());
				final List<Double> segmentCoordinates = firstEntry.getValue();
				// System.out.println("RailwayLink segment coordinates:"
				// + segmentCoordinates);
				// System.out.println("Distance:" + firstEntry.getKey());

				Vector2D m = new Vector2D(markerPost.getCoordinates().get(0), markerPost.getCoordinates().get(1));
				Vector2D a = new Vector2D(segmentCoordinates.get(0), segmentCoordinates.get(1));
				Vector2D b = new Vector2D(segmentCoordinates.get(2), segmentCoordinates.get(3));
				Vector2D ma = a.subtract(m);
				Vector2D mb = b.subtract(m);
				Vector2D ab = b.subtract(a);

				double aDotProduct = -ma.dotProduct(ab);
				double bDotProduct = mb.dotProduct(ab);
				// System.out.println("Dot product a:" + aDotProduct);
				// System.out.println("Dot product b:" + bDotProduct);
				if (aDotProduct < 0) {
					System.out.println(
							MessageFormat.format(
							"First dot product is negative for marker post [{0}] with coordinates [{1}].", markerPost.getId(), markerPost.getCoordinates()));
				}
				if (bDotProduct < 0) {
					System.out.println(MessageFormat.format("Second dot product is negative for marker post [{0}] with coordinates [{1}].", markerPost.getId(), markerPost.getCoordinates()));
				}
				final Double distance = firstEntry.getKey();
				if (distance >= 1.0e-6) {
					System.out.println(MessageFormat.format("Distance [{2}] is greater than 1.0e-6 for marker post [{0}] with coordinates [{1}].", markerPost.getId(), markerPost.getCoordinates(), distance));
				}
			}
		}
	}

	private void buildRailwayLinkSequences() {
		for (RailwayLinkSequence railwayLinkSequence : this.railwayLinkSequences.values()) {
			final List<RailwayLink> railwayLinks = new ArrayList<>(railwayLinkSequence.getRailwayLinkIds().size());
			for (String linkId : railwayLinkSequence.getRailwayLinkIds()) {
				final RailwayLink railwayLink = Ensure.mapContainsKey(this.railwayLinks, linkId, "railwayLinks");
				railwayLinks.add(railwayLink);
				Ensure.propertyIsNull(railwayLink.getRailwayLinkSequence(), railwayLink, "railwayLinkSequence");
				railwayLink.setRailwayLinkSequence(railwayLinkSequence);
				railwayLink.setRailwayLinkSequenceId(railwayLinkSequence.getId());
				final RailwayLine railwayLine = railwayLinkSequence.getRailwayLine();
				if (railwayLine == null) {
					railwayLinkSequence.setRailwayLine(railwayLink.getRailwayLine());
				} else {
					Ensure.propertyEquals(railwayLine, railwayLinkSequence, "railwayLine",
							railwayLink.getRailwayLine());
				}
			}
			railwayLinkSequence.setRailwayLinks(railwayLinks);
		}
	}

	public Iterable<RailwayNode> getRailwayNodes() {
		return this.railwayNodes.values();
	}

	public Iterable<RailwayLink> getRailwayLinks() {
		return this.railwayLinks.values();
	}

	public Iterable<RailwayStationNode> getRailwayStationNodes() {
		return this.railwayStationNodes.values();
	}

	public Iterable<RailwayLine> getRailwayLines() {
		return this.railwayLines.values();
	}

	public Iterable<RailwayLinkSequence> getRailwayLinkSequences() {
		return this.railwayLinkSequences.values();
	}

	public Iterable<MarkerPost> getMarkerPosts() {
		return this.markerPosts.values();
	}

}
