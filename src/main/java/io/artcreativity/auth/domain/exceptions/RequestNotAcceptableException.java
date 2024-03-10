package io.artcreativity.auth.domain.exceptions;

public class RequestNotAcceptableException extends RuntimeException{
    private String message;

    public RequestNotAcceptableException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
