package pers.rasskazov.railroads.exceptions;

import java.nio.file.Path;

public final class OutputFileWriteException extends RailroadsApplicationException {
    public OutputFileWriteException(Path inputFilePath, Throwable cause) {
        super("Can't read output file for path: " + inputFilePath.toString() + ".", cause);
    }
}
