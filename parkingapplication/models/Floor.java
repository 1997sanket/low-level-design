package practice.parkingapplication.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Floor {
    public static final int TOTAL_SLOTS = 2;

    private int slotCounter;
    private String floorId;
    private List<Slot> slots;
    private Boolean isAvailable;

    public Floor(String floorId) {
        this.slotCounter = 0;
        this.floorId = floorId;
        this.slots = new ArrayList<>(TOTAL_SLOTS);
        this.isAvailable = true;

        for (int i = 1; i <= TOTAL_SLOTS ; i++) {
            slots.add(new Slot("S"+ i, this));
        }
    }

    public List<Slot> getSlots() {
        return Collections.unmodifiableList(slots);
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public int getSlotCounter() {
        return slotCounter;
    }

    public void setSlotCounter(int slotCounter) {
        this.slotCounter = slotCounter;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId='" + floorId + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
