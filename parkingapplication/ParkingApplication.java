package practice.parkingapplication;

import practice.parkingapplication.models.*;
import practice.parkingapplication.services.ParkingService;

public class ParkingApplication {
    public static void main(String[] args) throws InterruptedException {

        Vehicle car = new Car("Blue", "MH01");
        Vehicle bike = new Bike("Red", "MH02");
        Vehicle van = new Van("White", "MH03");

        Vehicle car2 = new Car("Black", "MH04");
        Vehicle car3 = new Car("Violet", "MH05");

        ParkingService parkingService = new ParkingService();
        Ticket carTicket = parkingService.park(car);
        System.out.println("Car Ticket: " + carTicket);

        Ticket bikeTicket = parkingService.park(bike);
        System.out.println("Bike Ticket: " + bikeTicket);

        Ticket vanTicket = parkingService.park(van);
        System.out.println("Van Ticket: " + vanTicket);

        Ticket car2Ticket = parkingService.park(car2);
        System.out.println("Car 2 ticket: " + car2Ticket);

        parkingService.unPark(car2Ticket);

        System.out.println("Floors : " + ParkingService.getFloors());
    }
}
