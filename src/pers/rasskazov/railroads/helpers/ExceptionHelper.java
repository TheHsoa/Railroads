package pers.rasskazov.railroads.helpers;

import pers.rasskazov.railroads.exceptions.RailroadsApplicationException;

public final class ExceptionHelper {
    private ExceptionHelper() {
        // No OP
    }

    public static void logExceptionMessageToConsole(RailroadsApplicationException e) {
        System.err.println("Error: " + e.getMessageWithCause());
    }
}
