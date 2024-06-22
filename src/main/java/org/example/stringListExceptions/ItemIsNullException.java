package org.example.stringListExceptions;

public class ItemIsNullException extends RuntimeException{
    public ItemIsNullException() {
    }

    public ItemIsNullException(String message) {
        super(message);
    }

    public ItemIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemIsNullException(Throwable cause) {
        super(cause);
    }

    public ItemIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
