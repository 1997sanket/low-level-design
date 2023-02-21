package com.kamble.railwayapplication.services;

import com.kamble.railwayapplication.enums.StationName;
import com.kamble.railwayapplication.models.Station;
import com.kamble.railwayapplication.models.Ticket;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class RailwayStationService {
    public static final int COST_FOR_FIRST_HUNDRED_KM = 50;
    public static final int COST_PER_HUNDRED_KM_AFTER_FIRST_HUNDRED_KM = 3;
    private static Map<Station, Double> mapOfStationVsDistanceFromFirstStation;

    static {
        mapOfStationVsDistanceFromFirstStation = new HashMap<>();

        mapOfStationVsDistanceFromFirstStation.put(new Station(StationName.DELHI), 0.0);
        mapOfStationVsDistanceFromFirstStation.put(new Station(StationName.AGRA), 100.0);
        mapOfStationVsDistanceFromFirstStation.put(new Station(StationName.MATHURA), 250.0);
    }

    public Ticket getCost(StationName sourceStationEnum, StationName destinationStationEnum, boolean isReturnJourney) {

        Station sourceStation = new Station(sourceStationEnum);
        Station destinationStation = new Station(destinationStationEnum);

        double sourceDistanceFromFirstStation = mapOfStationVsDistanceFromFirstStation.get(sourceStation);
        double destinationDistanceFromFirstStation = mapOfStationVsDistanceFromFirstStation.get(destinationStation);

        double differenceBetweenStations = Math.abs(destinationDistanceFromFirstStation - sourceDistanceFromFirstStation);
        log.info("Difference between Station: " + differenceBetweenStations);

        double finalCost = COST_FOR_FIRST_HUNDRED_KM;

        if(differenceBetweenStations <= 100) {
            if(isReturnJourney) finalCost += COST_PER_HUNDRED_KM_AFTER_FIRST_HUNDRED_KM;
            return new Ticket(UUID.randomUUID().toString(), sourceStation, destinationStation, finalCost);
        }

        double singleJourneyDistance = differenceBetweenStations - 100;
        double returnJourneyDistance = differenceBetweenStations;

        double singleJourneyCost = (singleJourneyDistance * COST_PER_HUNDRED_KM_AFTER_FIRST_HUNDRED_KM)/100;
        finalCost += singleJourneyCost;

        log.info("Single Journey cost: " + singleJourneyCost);

        if(isReturnJourney) {
            double returnJourneyCost = ((returnJourneyDistance * COST_PER_HUNDRED_KM_AFTER_FIRST_HUNDRED_KM)/100);
            log.info("Return journey cost: " + returnJourneyCost);
            finalCost += returnJourneyCost;
        }

        return new Ticket(UUID.randomUUID().toString(), sourceStation, destinationStation, finalCost);
    }
}
