package pers.rasskazov.huawei.testfoqacandidate.helpers;

public final class ExceptionHelper {
    private ExceptionHelper() {
        // No OP
    }

    public static void logExceptionMessageToConsole(Throwable e) {
        System.out.println("Error: " + e.getMessage());
    }
}
