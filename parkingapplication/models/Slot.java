package practice.parkingapplication.models;

public class Slot {
    private String slotNo;
    private Floor floor;
    private Vehicle vehicle;
    private Boolean isAvailable;

    public Slot(String slotNo, Floor floor) {
        this.slotNo = slotNo;
        this.floor = floor;
        this.isAvailable = true;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotNo='" + slotNo + '\'' +
                ", floor=" + floor +
                ", vehicle=" + vehicle +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
