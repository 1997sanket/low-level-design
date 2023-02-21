package practice.parkingapplication.services;

import practice.parkingapplication.models.Ticket;

import java.time.LocalTime;

public class TicketService {

    private static double COST_FOR_ONE_SECOND = 10;

    public double calculateCost(Ticket ticket) {
        LocalTime parkTime = ticket.getParkTime();
        LocalTime unParkTime = ticket.getUnParkTime();

        return (unParkTime.getSecond() - parkTime.getSecond()) * COST_FOR_ONE_SECOND;
    }
}
