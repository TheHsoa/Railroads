package pers.rasskazov.railroads.exceptions;

import java.nio.file.Path;

public final class InputFileReadException extends RailroadsApplicationException {
    public InputFileReadException(Path inputFilePath, Throwable cause) {
        super("Can't read input file for path: " + inputFilePath.toString() + ".", cause);
    }
}
