package practice.parkingapplication.models;

public abstract class Vehicle {
    private String numberPlate;
    private String colour;

    public Vehicle(String colour, String numberPlate) {
        this.colour = colour;
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "numberPlate='" + numberPlate + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
