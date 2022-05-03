package pers.rasskazov.railroads.exceptions;

public final class EmptyArgumentsException extends RailroadsApplicationException {
    public EmptyArgumentsException() {
        super("Arguments must be set with directory path for input output files.");
    }
}
