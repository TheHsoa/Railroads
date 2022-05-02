package pers.rasskazov.huawei.testfoqacandidate.railroads.helpers;

import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.RailroadsApplicationException;

public final class ExceptionHelper {
    private ExceptionHelper() {
        // No OP
    }

    public static void logExceptionMessageToConsole(RailroadsApplicationException e) {
        System.err.println("Error: " + e.getMessageWithCause());
    }
}
