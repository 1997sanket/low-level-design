package com.kamble.railwayapplication;

import com.kamble.railwayapplication.enums.StationName;
import com.kamble.railwayapplication.services.RailwayStationService;

public class Main {
    public static void main(String[] args) {
        RailwayStationService service = new RailwayStationService();
        System.out.println(service.getCost(StationName.MATHURA, StationName.DELHI, true));
    }
}
