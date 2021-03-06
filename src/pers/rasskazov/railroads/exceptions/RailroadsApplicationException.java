package pers.rasskazov.railroads.exceptions;

import static pers.rasskazov.railroads.constants.StringConstants.EmptyString;

public abstract class RailroadsApplicationException extends Exception {
    RailroadsApplicationException(String message) {
        super(message);
    }

    RailroadsApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessageWithCause() {
        Throwable causeException = getCause();
        return getMessage() + (causeException == null ? EmptyString : " Cause exception message: " + causeException.getMessage());
    }
}
