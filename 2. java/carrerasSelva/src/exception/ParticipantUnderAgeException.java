package exception;

public class ParticipantUnderAgeException extends RuntimeException {
    public ParticipantUnderAgeException(String msg) {
        super(msg);
    }
}
