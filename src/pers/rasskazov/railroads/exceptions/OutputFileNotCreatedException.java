package pers.rasskazov.railroads.exceptions;

import java.nio.file.Path;

public final class OutputFileNotCreatedException extends RailroadsApplicationException {
    public OutputFileNotCreatedException(Path outputFilePath, Throwable cause) {
        super(GetErrorMessage(outputFilePath), cause);
    }

    public OutputFileNotCreatedException(Path outputFilePath) {
        super(GetErrorMessage(outputFilePath));
    }

    private static String GetErrorMessage(Path outputFilePath) {
        return "Output file for path not created: " + outputFilePath.toString() + ".";
    }
}
