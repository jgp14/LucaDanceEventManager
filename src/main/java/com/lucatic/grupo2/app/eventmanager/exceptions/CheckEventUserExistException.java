package com.lucatic.grupo2.app.eventmanager.exceptions;

public class CheckEventUserExistException extends EventManagerException {
    public CheckEventUserExistException(String message) {
        super(message);
    }

    public CheckEventUserExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
