package pers.rasskazov.railroads.testsupport;

public final class RailroadsErrorMessages {
    public static final String NumberOfTrainCoachesIncorrectFormatMessage =
            "Incorrect format for number of train coaches. Value must be positive integer number less than 1000.";

    private RailroadsErrorMessages() {
        // No OP
    }

    public static String generateConsoleErrorMessage(String exceptionMessage) {
        return "Error: " + exceptionMessage;
    }

    public static String generateForInputStringExceptionMessage(String inputStringValue) {
        return "For input string: \"" + inputStringValue + "\"";
    }

    public static String generateOutputFileErrorMessage(int errorLineNumber, String exceptionMessage) {
        return "Error at line " + errorLineNumber + ": " + exceptionMessage;
    }
}
