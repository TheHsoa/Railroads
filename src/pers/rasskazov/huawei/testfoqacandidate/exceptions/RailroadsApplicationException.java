package pers.rasskazov.huawei.testfoqacandidate.exceptions;

public abstract class RailroadsApplicationException extends Exception {
    RailroadsApplicationException(String message) {
        super(message);
    }

    RailroadsApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessageWithCause() {
        Throwable causeException = getCause();
        return getMessage() + (causeException == null ? "" : " Cause exception message: " + causeException.getMessage());
    }
}
