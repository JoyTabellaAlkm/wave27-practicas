package exception;

public class InvalidParticipantException extends RuntimeException {
    public InvalidParticipantException(String message) {
        super(message);
    }
}
