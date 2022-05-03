package pers.rasskazov.railroads.testsupport;

import pers.rasskazov.railroads.exceptions.RailroadsApplicationException;

import java.nio.file.Path;

public final class ErrorMessageGenerator {
    private ErrorMessageGenerator() {
        // No OP
    }

    public static String generateConsoleErrorMessage(RailroadsApplicationException exception) {
        return "Error: " + exception.getMessageWithCause();
    }

    public static String generateFileNotFoundCauseExceptionMessage(Path filePath) {
        return filePath.toString() + " (The system cannot find the file specified)";
    }

    public static String generateForInputStringExceptionMessage(String inputStringValue) {
        return "For input string: \"" + inputStringValue + "\"";
    }

    public static String generateOutputFileErrorMessage(int errorLineNumber, RailroadsApplicationException exception) {
        return "Error at line " + errorLineNumber + ": " + exception.getMessageWithCause();
    }
}
