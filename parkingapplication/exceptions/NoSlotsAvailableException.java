package practice.parkingapplication.exceptions;

public class NoSlotsAvailableException extends RuntimeException {

    public NoSlotsAvailableException(String message) {
        super(message);
    }
}
