package apps.myuzinc.events.exceptions;

public class PhoneNumberAlreadyInUse extends RuntimeException{
    public PhoneNumberAlreadyInUse(String message) {
        super(message);
    }
}
