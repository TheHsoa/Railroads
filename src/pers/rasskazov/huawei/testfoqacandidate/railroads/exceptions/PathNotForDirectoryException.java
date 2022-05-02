package pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions;

import java.nio.file.Path;

public final class PathNotForDirectoryException extends RailroadsApplicationException {
    public PathNotForDirectoryException(Path filePath) {
        super("Path is not for directory: " + filePath.toString() + ".");
    }
}
