package ir.safari.show.config.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String messageKey) {
        super(messageKey);
    }
}
