package pers.rasskazov.railroads;

import pers.rasskazov.railroads.exceptions.DirectoryNotSetException;
import pers.rasskazov.railroads.exceptions.EmptyArgumentsException;

final class RailroadsArgumentsParser {
    private RailroadsArgumentsParser() {
        // No OP
    }

    static String parse(String[] arguments) throws EmptyArgumentsException, DirectoryNotSetException {
        if (arguments == null || arguments.length == 0) {
            throw new EmptyArgumentsException();
        }
        String directoryPathString = arguments[0];
        if (directoryPathString == null) {
            throw new DirectoryNotSetException();
        }

        return directoryPathString;
    }
}
