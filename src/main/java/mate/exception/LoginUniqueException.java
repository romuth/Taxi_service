package mate.exception;

public class LoginUniqueException extends RuntimeException {
    public LoginUniqueException(String message) {
        super(message);
    }
}
