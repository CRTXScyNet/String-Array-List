package org.example.stringListExceptions;

public class StringNotFoundException extends RuntimeException{
    public StringNotFoundException() {
    }

    public StringNotFoundException(String message) {
        super(message);
    }

    public StringNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringNotFoundException(Throwable cause) {
        super(cause);
    }

    public StringNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
