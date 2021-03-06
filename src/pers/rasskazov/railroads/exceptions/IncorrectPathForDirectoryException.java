package pers.rasskazov.railroads.exceptions;

public final class IncorrectPathForDirectoryException extends RailroadsApplicationException {
    public IncorrectPathForDirectoryException(String directoryPathString) {
        super("Invalid path string for directory: " + directoryPathString + ".");
    }
}
