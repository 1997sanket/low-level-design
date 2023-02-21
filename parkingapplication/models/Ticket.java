package practice.parkingapplication.models;

import java.time.LocalTime;
import java.util.UUID;

public class Ticket {
    private String ticketNo;
    private Slot slot;
    private LocalTime parkTime;
    private LocalTime unParkTime;

    public Ticket(Slot slot, LocalTime parkTime) {
        this.ticketNo = UUID.randomUUID().toString();
        this.slot = slot;
        this.parkTime = parkTime;
    }

    public void setUnParkTime(LocalTime unParkTime) {
        this.unParkTime = unParkTime;
    }

    public Slot getSlot() {
        return slot;
    }

    public LocalTime getParkTime() {
        return parkTime;
    }

    public LocalTime getUnParkTime() {
        return unParkTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNo='" + ticketNo + '\'' +
                ", slot=" + slot +
                ", parkTime=" + parkTime +
                ", unParkTime=" + unParkTime +
                '}';
    }
}
