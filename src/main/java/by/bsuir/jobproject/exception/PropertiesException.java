package by.bsuir.jobproject.exception;


public class PropertiesException extends RuntimeException{
    public PropertiesException(String message) {
        super(message);
    }

    public PropertiesException(Throwable cause) {
        super(cause);
    }

    public PropertiesException(String message, Throwable cause) {
        super(message, cause);
    }
}
