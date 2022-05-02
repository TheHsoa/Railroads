package pers.rasskazov.huawei.testfoqacandidate.exceptions;

import java.nio.file.Path;

public final class OutputFileWriteException extends RailroadsApplicationException {
    public OutputFileWriteException(Path inputFilePath, Throwable cause) {
        super("Can't read input file for path: " + inputFilePath.toString() + ".", cause);
    }
}
