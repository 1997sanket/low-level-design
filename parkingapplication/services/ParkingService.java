package practice.parkingapplication.services;

import practice.parkingapplication.exceptions.NoSlotsAvailableException;
import practice.parkingapplication.models.Floor;
import practice.parkingapplication.models.Slot;
import practice.parkingapplication.models.Ticket;
import practice.parkingapplication.models.Vehicle;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingService {

    public static final int TOTAL_FLOORS = 2;

    private static List<Floor> floors;
    private static SlotService slotService;
    private static TicketService ticketService;

    static {
        floors = new ArrayList<>(TOTAL_FLOORS);
        slotService = new SlotService();
        ticketService = new TicketService();

        for (int i = 1; i <= TOTAL_FLOORS; i++) {
            floors.add(new Floor("F" + i));
        }
    }

    public Ticket park(Vehicle vehicle) {

        boolean vehicleAdded = false;
        Ticket ticket = null;

        for(Floor floor : floors) {
            if(floor.getAvailable() == false) continue;

            List<Slot> slots = floor.getSlots();
            for(Slot slot: slots) {
                if(slot.getIsAvailable()) {
                    slotService.addVehicle(slot, vehicle);
                    vehicleAdded = true;
                    slot.setAvailable(false);
                    ticket = new Ticket(slot, LocalTime.now());
                    break;
                }
            }

            if(vehicleAdded) break;
        }

        if(vehicleAdded == false) throw new NoSlotsAvailableException("Parking is full");

        return ticket;
    }

    public double unPark(Ticket ticket) {

        // Empty that slot
        Slot slot = ticket.getSlot();
        slot.setVehicle(null);
        slot.setAvailable(true);

        Floor floor = slot.getFloor();
        int slotCounter = floor.getSlotCounter();
        if(slotCounter == Floor.TOTAL_SLOTS) {
            slotCounter--;
            floor.setSlotCounter(slotCounter);
            floor.setAvailable(true);
        }

        ticket.setUnParkTime(LocalTime.now());

        return ticketService.calculateCost(ticket);
    }

    public static List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }
}
