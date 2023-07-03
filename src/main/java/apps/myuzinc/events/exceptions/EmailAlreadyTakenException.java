package apps.myuzinc.events.exceptions;

public class EmailAlreadyTakenException extends RuntimeException{
    public EmailAlreadyTakenException(String message) {
        super(message);
    }
}
