package practice.parkingapplication.services;

import practice.parkingapplication.models.Floor;
import practice.parkingapplication.models.Slot;
import practice.parkingapplication.models.Vehicle;

public class SlotService {

    public void addVehicle(Slot slot, Vehicle vehicle) {
        slot.setVehicle(vehicle);

        int slotCounter = slot.getFloor().getSlotCounter();
        slotCounter++;
        slot.getFloor().setSlotCounter(slotCounter);

        if(slotCounter == Floor.TOTAL_SLOTS) {
            slot.getFloor().setAvailable(false);
        }
    }
}
