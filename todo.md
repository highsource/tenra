# Todo

## Network

Contains references to lines

## OwnerAuthority

Can be ignored -> network

## MaintenanceAuthority

Can be ignored -> network

=================================================================================================


## RailwayElectrification

* networkRef -> RailwayLinkSequence + km von bis
* electrified

## NominalTrackGauge

* networkRef -> RailwayLinkSequence + km von bis
* gauge...

# TrafficFlowDirection

* networkRef -> RailwayLinkSequence + km von bis
* ...

## DesignSpeed

* networkRef -> RailwayLinkSequence + km von bis
* speed

## RailwayType

* networkRef -> RailwayLinkSequence + km von bis

## ConditionOfFacility

* networkRef -> RailwayLinkSequence + km von bis

## NumberofTracks

* networkRef -> RailwayLinkSequence + km von bis

## RailwayUse

* networkRef -> RailwayLinkSequence + km von bis

## VerticalPosition

* networkRef -> RailwayLinkSequence + km von bis

---------------------------------------------------------------------------------

# Done

## RailwayLinkSequence

* directedLink -> RailwayLink plus direction


# Built

## MarkerPost

* networkId
* routeId -> RailwayLine
* location (171km)


## RailwayLineType

* networkId
* link -> RailwayLink
* geographicalName
* railwayLineCode

## RailwayLink

* networkId -> Network
* startNodeId -> RailwayNode
* endNodeId -> RailwayNode

## RailwayNode

* networkId
* spokeStart -> RailwayLink
* spokeEnd -> RailwayLink

## RailwayStationCode

* railwayStationNodeId -> RailwayStationNode

## RailwayStationNode

* networkId
* spokeStart -> RailwayLink
* spokeEnd -> RailwayLink
