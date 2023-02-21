package com.kamble.railwayapplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Ticket {
    private String id;
    private Station sourceStation;
    private Station destinationStation;
    private double cost;
}
